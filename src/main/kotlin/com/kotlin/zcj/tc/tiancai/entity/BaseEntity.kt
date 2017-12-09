package com.kotlin.zcj.tc.tiancai.entity

import java.util.*

/**
 * @Since2017/12/9 ZhaCongJie@HF
 */
open class BaseEntity {
    var createBy: String = "";
    var createTime: Date = Date();
    var updateBy: String = "";
    var updateTime: Date = Date();
}