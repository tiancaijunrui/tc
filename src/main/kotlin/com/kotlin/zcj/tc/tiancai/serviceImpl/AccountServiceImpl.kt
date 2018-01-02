package com.kotlin.zcj.tc.tiancai.serviceImpl

import com.kotlin.zcj.tc.data.Tables.T_TC_ACCOUNT
import com.kotlin.zcj.tc.data.Tables.T_TC_CORP_CODE
import com.kotlin.zcj.tc.data.tables.TTcAccount
import com.kotlin.zcj.tc.data.tables.records.TTcAccountRecord
import com.kotlin.zcj.tc.tiancai.entity.AccountCondition
import com.kotlin.zcj.tc.tiancai.entity.Page
import com.kotlin.zcj.tc.tiancai.service.AccountService
import org.jooq.DSLContext
import org.jooq.SelectConditionStep
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import sun.misc.MessageUtils.where
import javax.annotation.Resource

/**
 * @Since2017/12/27 ZhaCongJie@HF
 */
@Service("accountService")
class AccountServiceImpl : AccountService {
    @Resource
    var dsl: DSLContext? = null

    @Resource
    lateinit private var stringRedis: StringRedisTemplate;


    override fun pageAccount(account: AccountCondition, page: Page<TTcAccountRecord>): Page<TTcAccountRecord> {
        if (page.autoPaging) {
            val mdl = dsl!!.selectCount().from(T_TC_ACCOUNT).leftAntiJoin(T_TC_CORP_CODE).on(T_TC_ACCOUNT.CORP_ID.eq(T_TC_CORP_CODE.CORP_ID))
            mdl.where(T_TC_ACCOUNT.USER_ID.eq(account.userId))
            if (!StringUtils.isEmpty(account.corpCode)) {
                mdl.and(T_TC_CORP_CODE.CORP_CODE.like("%" + account.corpCode + "%"))
            }
            page.total = mdl.fetchOne(0, Int::class.java)
        }
        val mdl = dsl!!.selectFrom(T_TC_ACCOUNT).where(T_TC_ACCOUNT.USER_ID.eq(account.userId))
        if (!StringUtils.isEmpty(account.corpCode)) {
            mdl.and(T_TC_CORP_CODE.CORP_CODE.like("%" + account.corpCode + "%"))
        }
        if (page.autoPaging) {
            mdl.limit(page.size).offset((page.pageNo - 1) * (page.size + 1))
        }
        page.data = mdl.fetch()
        return page;
    }
}