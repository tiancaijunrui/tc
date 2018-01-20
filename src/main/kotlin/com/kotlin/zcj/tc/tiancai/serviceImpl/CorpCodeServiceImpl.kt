package com.kotlin.zcj.tc.tiancai.serviceImpl

import com.kotlin.zcj.tc.data.Tables.T_TC_CORP_CODE
import com.kotlin.zcj.tc.data.tables.records.TTcCorpCodeRecord
import com.kotlin.zcj.tc.tiancai.controller.CorpCodeTypeEnum
import com.kotlin.zcj.tc.tiancai.service.CorpCodeService
import com.kotlin.zcj.tc.tiancai.utils.TcExecutionContext
import com.kotlin.zcj.tc.tiancai.utils.TcUtils
import org.jooq.DSLContext
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import java.sql.Timestamp
import java.util.*
import javax.annotation.Resource

/**
 * @Since2018/1/2 ZhaCongJie@HF
 */



@Service("corpCodeService")
class CorpCodeServiceImpl : CorpCodeService {
    @Resource
    lateinit var dsl: DSLContext

    override fun save(corpCode: TTcCorpCodeRecord): String {
        val corpId = TcUtils.genUUID()
        val now = Date()
        if (StringUtils.isEmpty(corpCode.corpId)) {
            corpCode.corpId = corpId
            dsl.insertInto(T_TC_CORP_CODE).set(T_TC_CORP_CODE.CORP_ID, corpId)
                    .set(T_TC_CORP_CODE.CORP_CODE, corpCode.corpCode).set(T_TC_CORP_CODE.LINK, corpCode.link)
                    .set(T_TC_CORP_CODE.INTRODUCE, corpCode.introduce).set(T_TC_CORP_CODE.TYPE, corpCode.type)
                    .set(T_TC_CORP_CODE.CREATE_BY, TcExecutionContext.getUserId()).set(T_TC_CORP_CODE.CREATE_TIME, Timestamp(now.time))
                    .set(T_TC_CORP_CODE.UPDATE_BY, TcExecutionContext.getUserId()).set(T_TC_CORP_CODE.UPDATE_TIME, Timestamp(now.time)).execute()
            return corpId
        }
        val mdl = dsl.update(T_TC_CORP_CODE)
        if (!StringUtils.isEmpty(corpCode.corpCode)) {
            mdl.set(T_TC_CORP_CODE.CORP_CODE, corpCode.corpCode)
        }
        if (!StringUtils.isEmpty(corpCode.link)) {
            mdl.set(T_TC_CORP_CODE.LINK, corpCode.link)
        }
        if (!StringUtils.isEmpty(corpCode.introduce)) {
            mdl.set(T_TC_CORP_CODE.INTRODUCE, corpCode.introduce)
        }
        if (!StringUtils.isEmpty(corpCode.type)) {
            mdl.set(T_TC_CORP_CODE.TYPE, corpCode.type)
        }
        mdl.set(T_TC_CORP_CODE.UPDATE_BY, TcExecutionContext.getUserId()).set(T_TC_CORP_CODE.UPDATE_TIME, Timestamp(now.time)).execute()
        return corpCode.corpId
    }

    override fun listCorp(): MutableList<TTcCorpCodeRecord> {
        val corpCodeList: MutableList<TTcCorpCodeRecord>
        corpCodeList = dsl.selectFrom(T_TC_CORP_CODE).where(
                ((T_TC_CORP_CODE.CREATE_BY.eq(TcExecutionContext.getUserId()).and(T_TC_CORP_CODE.TYPE.eq(CorpCodeTypeEnum.PERSONAL.toString())))
                        .or(T_TC_CORP_CODE.TYPE.eq(CorpCodeTypeEnum.PUBLIC.toString())))
        ).orderBy(T_TC_CORP_CODE.UPDATE_TIME.desc()).fetch()
        return corpCodeList;
    }

}