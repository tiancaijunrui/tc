package com.kotlin.zcj.tc.tiancai.entity

import com.kotlin.zcj.tc.tiancai.controller.CorpCodeTypeEnum

/**
 * @Since2018/1/21 ZhaCongJie@HF
 */
class CorpCodeCondition {
    var corpId: String? = ""
    var corpCode: String = ""
    var link: String? = ""
    var introduce: String? = ""
    var type : String = CorpCodeTypeEnum.PERSONAL.toString()
}