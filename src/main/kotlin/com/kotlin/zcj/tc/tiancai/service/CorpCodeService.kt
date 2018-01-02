package com.kotlin.zcj.tc.tiancai.service

import com.kotlin.zcj.tc.data.tables.records.TTcCorpCodeRecord
import org.springframework.stereotype.Service

/**
 * @Since2018/1/2 ZhaCongJie@HF
 */
@Service
interface CorpCodeService {
    fun listCorp() : MutableList<TTcCorpCodeRecord>
    fun save( corpCode : TTcCorpCodeRecord) : String


}