package com.kotlin.zcj.tc.tiancai.entity

import org.hibernate.validator.constraints.Email
import javax.validation.constraints.Pattern

/**
 * @Since2017/12/30 ZhaCongJie@HF
 */
class AccountCondition : BaseEntity() {
//    @Pattern(regexp = "^(\\d{18,18}|\\d{15,15}|(\\d{17,17}[x|X]))$", message = "身份证号格式错误")
    var accountId: String = "";
    var corpCode: String = "";
    var userId: String = "";
    var corpId: String = "";
    var loginName: String = "";
    var password: String = "";
    var phone: String = "";
    @Email(message = "输入正确的邮箱格式不正确")
    var email: String = "";
    var answerOne: String = "";
    var answerTwo: String = "";
    var answerThree: String = "";
    var answerFour: String = "";
}