package com.kotlin.zcj.tc.tiancai.utils

import java.util.*

/**
 * @Since2017/12/9 ZhaCongJie@HF
 */
object ScUtils {
    fun genUUID(): String {
        return UUID.randomUUID().toString().replace("-", "");
    }
}