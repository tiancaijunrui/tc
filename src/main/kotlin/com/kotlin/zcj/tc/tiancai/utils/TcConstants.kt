package com.kotlin.zcj.tc.tiancai.utils

import java.net.URLEncoder.encode

/**
 * @Since2017/12/19 ZhaCongJie@HF
 */
object TcConstants {
    var target_service: String = "user.auth.quick.login";
    var return_url : String = "http://127.0.0.1:8081/index/index.html";
    var scope : String = "auth_user";
    var redirect_uri : String = encode("http://127.0.0.1:8081/index/index.html");

}