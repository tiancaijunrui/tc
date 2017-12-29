package com.kotlin.zcj.tc.tiancai.serviceImpl

import com.kotlin.zcj.tc.data.Tables.T_TC_ACCOUNT
import com.kotlin.zcj.tc.data.tables.TTcAccount
import com.kotlin.zcj.tc.data.tables.records.TTcAccountRecord
import com.kotlin.zcj.tc.tiancai.entity.Page
import com.kotlin.zcj.tc.tiancai.service.AccountService
import org.jooq.DSLContext
import org.jooq.SelectConditionStep
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
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


    override fun pageAccount(account: TTcAccountRecord, page: Page<TTcAccountRecord>): Page<TTcAccount>? {
//        val mdl = dsl!!.selectFrom(Tables.T_TC_ACCOUNT).where("1 = 1")
//        genMdl(account, mdl);
        if (page.autoPaging) {
            var mdl = dsl!!.selectCount().from(T_TC_ACCOUNT).where("1=1").fetchOne(0, Int::class.java)
//            genMdl(account, mdl).fetchOne(0,Int)
        }
        return null;
    }

    private fun genMdl(account: TTcAccount, mdl: SelectConditionStep<TTcAccountRecord>): SelectConditionStep<TTcAccountRecord> {
        if (!StringUtils.isEmpty(account.USER_ID)) {
            mdl.and(T_TC_ACCOUNT.USER_ID.eq(account.USER_ID))
        }
        if (!StringUtils.isEmpty(account.CORP_CODE)) {
            mdl.and(T_TC_ACCOUNT.CORP_CODE.eq(account.USER_ID))
        }
        return mdl;
    }

}