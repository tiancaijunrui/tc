package com.kotlin.zcj.tc.tiancai.service

import com.kotlin.zcj.tc.data.tables.records.TTcAccountRecord
import com.kotlin.zcj.tc.tiancai.entity.AccountCondition
import com.kotlin.zcj.tc.tiancai.entity.Page
import org.springframework.stereotype.Service

/**
 * @Since2017/12/27 ZhaCongJie@HF
 */
@Service
interface AccountService {
    fun pageAccount(account: AccountCondition, page: Page<TTcAccountRecord>): Page<TTcAccountRecord>?

}