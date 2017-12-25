package com.kotlin.zcj.tc.tiancai.utils

import com.alibaba.fastjson.JSON
import com.auth0.jwt.internal.org.apache.commons.lang3.StringUtils
import com.kotlin.zcj.tc.tiancai.entity.User
import java.util.*
import javax.servlet.http.HttpServletRequest

/**
 * @Since2017/12/9 ZhaCongJie@HF
 */
object TcUtils {
    private var key = "zcj19921123";
    private var TTLMillis: Long = 60 * 60 * 1000L;
    fun genUUID(): String {
        return UUID.randomUUID().toString().replace("-", "");
    }

    fun getIP(request: HttpServletRequest): String? {
        var ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotBlank(ip) && !"unKnow".equals(ip, true)) {
            val index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotBlank(ip) && !"unKnow".equals(ip, true)) {
            return ip;
        }
        return request.remoteAddr;
    }

    fun getUserByJson(jsonBody: String): Map<String,String> {
        val map = JSON.parse(jsonBody) as Map<*, *>;
        val dataMap = map["alipay_user_info_share_response"] as Map<*, *>;
        return dataMap as Map<String, String>;
    }
}