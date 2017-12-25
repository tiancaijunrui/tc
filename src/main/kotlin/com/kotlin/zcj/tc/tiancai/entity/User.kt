package com.kotlin.zcj.tc.tiancai.entity

import java.util.*

/**
 * @Since2017/12/9 ZhaCongJie@HF
 */
class User : BaseEntity() {
    var userId: String = "";
    var loginName: String = "";
    var password: String = "";
    var email: String = "";
    var phone: String = "";
    var age: Int = 0;
    var birthday: Date? = null;
}