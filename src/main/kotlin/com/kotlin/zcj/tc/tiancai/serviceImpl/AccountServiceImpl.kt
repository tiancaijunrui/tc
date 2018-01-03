package com.kotlin.zcj.tc.tiancai.serviceImpl

import com.kotlin.zcj.tc.data.Tables.T_TC_ACCOUNT
import com.kotlin.zcj.tc.data.Tables.T_TC_CORP_CODE
import com.kotlin.zcj.tc.data.tables.TTcAccount
import com.kotlin.zcj.tc.data.tables.records.TTcAccountRecord
import com.kotlin.zcj.tc.tiancai.entity.AccountCondition
import com.kotlin.zcj.tc.tiancai.entity.Page
import com.kotlin.zcj.tc.tiancai.service.AccountService
import com.kotlin.zcj.tc.tiancai.utils.TcExecutionContext
import com.kotlin.zcj.tc.tiancai.utils.TcUtils
import org.jooq.DSLContext
import org.jooq.SelectConditionStep
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import sun.misc.MessageUtils.where
import java.sql.Timestamp
import java.util.*
import javax.annotation.Resource

/**
 * @Since2017/12/27 ZhaCongJie@HF
 */
@Service("accountService")
class AccountServiceImpl : AccountService {
    override fun save(account: AccountCondition): String {
        val accountId = TcUtils.genUUID()
        val now = Date()
        if (StringUtils.isEmpty(account.accountId)) {
            account.accountId = accountId
            dsl.insertInto(T_TC_ACCOUNT).set(T_TC_ACCOUNT.CORP_ID, account.corpId).set(T_TC_ACCOUNT.LOGIN_NAME, account.loginName)
                    .set(T_TC_ACCOUNT.PASSWORD, account.password).set(T_TC_ACCOUNT.USER_ID, account.userId).set(T_TC_ACCOUNT.EMAIL, account.email)
                    .set(T_TC_ACCOUNT.ACCOUNT_ID, account.accountId).set(T_TC_ACCOUNT.PHONE, account.phone).set(T_TC_ACCOUNT.ENCRYPTED_ANSWERS_ONE, account.answerOne)
                    .set(T_TC_ACCOUNT.ENCRYPTED_ANSWERS_TWO, account.answerTwo).set(T_TC_ACCOUNT.ENCRYPTED_ANSWERS_THREE, account.answerThree).set(T_TC_ACCOUNT.ENCRYPTED_ANSWERS_FOUR, account.answerFour)
                    .set(T_TC_ACCOUNT.UPDATE_TIME, Timestamp(now.time)).set(T_TC_ACCOUNT.UPDATE_BY, TcExecutionContext.getUserId()).set(T_TC_ACCOUNT.CREATE_BY, TcExecutionContext.getUserId())
                    .set(T_TC_ACCOUNT.CREATE_TIME, Timestamp(now.time)).execute()
        }
        return accountId;
    }

    @Resource
    lateinit var dsl: DSLContext

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