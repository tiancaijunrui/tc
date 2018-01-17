package com.kotlin.zcj.tc.tiancai.serviceImpl

import com.kotlin.zcj.tc.data.Tables.T_TC_ACCOUNT
import com.kotlin.zcj.tc.data.Tables.T_TC_CORP_CODE
import com.kotlin.zcj.tc.data.tables.records.TTcAccountRecord
import com.kotlin.zcj.tc.tiancai.entity.AccountCondition
import com.kotlin.zcj.tc.tiancai.entity.Page
import com.kotlin.zcj.tc.tiancai.service.AccountService
import com.kotlin.zcj.tc.tiancai.utils.TcExecutionContext
import com.kotlin.zcj.tc.tiancai.utils.TcUtils
import org.jooq.DSLContext
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import java.sql.Timestamp
import java.util.*
import javax.annotation.Resource

/**
 * @Since2017/12/27 ZhaCongJie@HF
 */
@Service("accountService")
class AccountServiceImpl : AccountService {
    override fun update(account: AccountCondition): String {
        dsl.update(tAccount).set(tAccount.USER_ID, account.userId).set(tAccount.LOGIN_NAME, account.loginName)
                .set(tAccount.CORP_ID, account.corpId).set(tAccount.ENCRYPTED_ANSWERS_ONE, account.answerOne)
                .set(tAccount.ENCRYPTED_ANSWERS_TWO, account.answerTwo).set(tAccount.ENCRYPTED_ANSWERS_THREE, account.answerThree)
                .set(tAccount.ENCRYPTED_ANSWERS_FOUR, account.answerFour).set(tAccount.UPDATE_TIME, Timestamp(Date().time))
                .set(tAccount.PASSWORD, account.password).where(tAccount.ACCOUNT_ID.eq(account.accountId)).execute()
        return account.accountId
    }

    override fun getByAccountId(accountId: String): AccountCondition? {
        val accountRecord: TTcAccountRecord? = dsl.selectFrom(tAccount).where(tAccount.ACCOUNT_ID.eq(accountId)).fetchOne()
        if (accountRecord == null) {
            return null;
        }
        return genAccountByRecord(accountRecord)
    }

    private fun genAccountByRecord(accountRecord: TTcAccountRecord): AccountCondition {
        val exAccount = AccountCondition()
        exAccount.userId = accountRecord.userId
        exAccount.accountId = accountRecord.accountId
        exAccount.loginName = accountRecord.loginName
        exAccount.corpId = accountRecord.corpId
        exAccount.answerOne = accountRecord.encryptedAnswersOne
        exAccount.answerTwo = accountRecord.encryptedAnswersTwo
        exAccount.answerThree = accountRecord.encryptedAnswersThree
        exAccount.answerFour = accountRecord.encryptedAnswersFour
        exAccount.password = accountRecord.password
        exAccount.phone = accountRecord.phone
        exAccount.email = accountRecord.email
        return exAccount
    }

    @Resource
    lateinit var dsl: DSLContext

    @Resource
    private lateinit var stringRedis: StringRedisTemplate;
    private val tAccount = T_TC_ACCOUNT
    private val tCorpCode = T_TC_CORP_CODE

    override fun save(account: AccountCondition): String {
        val accountId = TcUtils.genUUID()
        val now = Date()
        if (StringUtils.isEmpty(account.accountId)) {
            account.accountId = accountId
            dsl.insertInto(tAccount).set(tAccount.CORP_ID, account.corpId).set(tAccount.LOGIN_NAME, account.loginName)
                    .set(tAccount.PASSWORD, account.password).set(tAccount.USER_ID, account.userId).set(tAccount.EMAIL, account.email)
                    .set(tAccount.ACCOUNT_ID, account.accountId).set(tAccount.PHONE, account.phone).set(tAccount.ENCRYPTED_ANSWERS_ONE, account.answerOne)
                    .set(tAccount.ENCRYPTED_ANSWERS_TWO, account.answerTwo).set(tAccount.ENCRYPTED_ANSWERS_THREE, account.answerThree).set(tAccount.ENCRYPTED_ANSWERS_FOUR, account.answerFour)
                    .set(tAccount.UPDATE_TIME, Timestamp(now.time)).set(tAccount.UPDATE_BY, TcExecutionContext.getUserId()).set(tAccount.CREATE_BY, TcExecutionContext.getUserId())
                    .set(tAccount.CREATE_TIME, Timestamp(now.time)).execute()
        }
        return accountId;
    }

    override fun pageAccount(account: AccountCondition, page: Page<AccountCondition>): Page<AccountCondition> {
        if (StringUtils.isEmpty(account.userId)) {
            account.userId = TcExecutionContext.getUserId()
        }
        if (page.autoPaging) {
            val mdl = dsl.selectCount().from(tAccount).leftJoin(tCorpCode).on(tAccount.CORP_ID.eq(tCorpCode.CORP_ID))
            mdl.where(tAccount.USER_ID.eq(account.userId))
            if (!StringUtils.isEmpty(account.corpCode)) {
                mdl.and(tCorpCode.CORP_CODE.like("%" + account.corpCode + "%"))
            }
            page.total = mdl.fetchOne(0, Int::class.java)
        }
        val mdl = dsl.select().from(tAccount).leftJoin(tCorpCode).on(tAccount.CORP_ID.eq(tCorpCode.CORP_ID))
        mdl.where(tAccount.USER_ID.eq(account.userId))
        if (!StringUtils.isEmpty(account.corpCode)) {
            mdl.and(tCorpCode.CORP_CODE.like("%" + account.corpCode + "%"))
        }
        if (page.autoPaging) {
            mdl.limit(page.size).offset((page.pageNo - 1) * (page.size + 1))
        }
        val accountList = mutableListOf<AccountCondition>()
        mdl.forEach({
            val exAccount = AccountCondition()
            exAccount.userId = it[tAccount.USER_ID]
            exAccount.accountId = it[tAccount.ACCOUNT_ID]
            exAccount.loginName = it[tAccount.LOGIN_NAME]
            exAccount.corpId = it[tAccount.CORP_ID]
            exAccount.corpCode = it[tCorpCode.CORP_CODE]
            exAccount.answerOne = it[tAccount.ENCRYPTED_ANSWERS_ONE]
            exAccount.answerTwo = it[tAccount.ENCRYPTED_ANSWERS_TWO]
            exAccount.answerThree = it[tAccount.ENCRYPTED_ANSWERS_THREE]
            exAccount.answerFour = it[tAccount.ENCRYPTED_ANSWERS_FOUR]
            exAccount.password = it[tAccount.PASSWORD]
            accountList.add(exAccount)
        })
        page.data = accountList
        return page;
    }
}