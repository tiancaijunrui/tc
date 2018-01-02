package com.kotlin.zcj.tc.tiancai.serviceImpl

import com.kotlin.zcj.tc.data.Tables.T_TC_CORP_CODE
import com.kotlin.zcj.tc.data.tables.records.TTcCorpCodeRecord
import com.kotlin.zcj.tc.tiancai.service.CorpCodeService
import com.kotlin.zcj.tc.tiancai.utils.TcExecutionContext
import org.jooq.DSLContext
import org.springframework.stereotype.Service
import javax.annotation.Resource

/**
 * @Since2018/1/2 ZhaCongJie@HF
 */
@Service("corpCodeService")
class CorpCodeServiceImpl : CorpCodeService {
    @Resource
    var dsl: DSLContext? = null

    override fun listCorp(): MutableList<TTcCorpCodeRecord> {
        val corpCodeList: MutableList<TTcCorpCodeRecord>
        corpCodeList = dsl!!.selectFrom(T_TC_CORP_CODE).where(T_TC_CORP_CODE.CREATE_BY.eq(TcExecutionContext.getUserId()))
                .orderBy(T_TC_CORP_CODE.UPDATE_TIME.desc()).fetch()
        return corpCodeList;
    }

}