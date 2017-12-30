package com.kotlin.zcj.tc.tiancai.entity

import org.springframework.web.context.ContextLoader
import java.util.ArrayList

/**
 * @Since2017/12/27 ZhaCongJie@HF
 */
class Page<T> {
    var size: Int = 10;
    var pageNo: Int = 1;
    var autoPaging: Boolean = true;
    var total : Int = 0;
    var data  = mutableListOf<T>()

}