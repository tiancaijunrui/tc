package com.kotlin.zcj.tc.tiancai.utils

import java.net.URLEncoder.encode

/**
 * @Since2017/12/19 ZhaCongJie@HF
 */
object TcConstants {
    val target_service: String = "user.auth.quick.login";
    val return_url : String = "http://127.0.0.1:8081/index/index.html";
    val scope : String = "auth_user";
    val redirect_uri : String = encode("http://127.0.0.1:8081/index/index.html");
    val status_success = "Success";
    val pre_token = "TIANCAI";

}