package com.kotlin.zcj.tc.tiancai.entity

import com.kotlin.zcj.tc.data.tables.records.TTcAccountRecord
import org.hibernate.validator.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

/**
 * @Since2017/12/30 ZhaCongJie@HF
 */
class AccountCondition : BaseEntity() {
    var accountId: String = "";
    var corpCode: String = "";
    var userId: String = "";
    var corpId: String = "";
    var loginName: String = "";
    var password: String = "";
    @Pattern(regexp = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}\$", message = "请输入正确的手机格式")
    var phone: String = "";
    @Email(message = "输入正确的邮箱格式不正确")
    var email: String = "";
    var answerOne: String = "";
    var answerTwo: String = "";
    var answerThree: String = "";
    var answerFour: String = "";
    var page : Page<TTcAccountRecord> = Page<TTcAccountRecord>()
}