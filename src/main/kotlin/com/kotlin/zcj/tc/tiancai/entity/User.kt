package com.kotlin.zcj.tc.tiancai.entity

import java.util.*

/**
 * @Since2017/12/9 ZhaCongJie@HF
 */
class User : BaseEntity() {
    private var userId: String = "";
    private var loginName: String = "";
    private var password: String = "";
    private var email: String = "";
    private var phone: String = "";
    private var age: Int = 0;
    private var birthday: Date? = null;
}