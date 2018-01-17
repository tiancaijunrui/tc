package com.kotlin.zcj.tc.tiancai.utils

import com.alibaba.fastjson.JSON
import com.auth0.jwt.internal.org.apache.commons.lang3.StringUtils
import com.kotlin.zcj.tc.data.tables.records.TTcUserRecord
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.security.Key
import java.util.*
import javax.crypto.spec.SecretKeySpec
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.xml.bind.DatatypeConverter

/**
 * @Since2017/12/9 ZhaCongJie@HF
 */
object TcUtils {
    private val key = "zcj19921123";
    private val TTLMillis: Long = 60 * 60 * 1000L;
    private val issuer = "TC"
    private val subject = "TC"
    fun genUUID(): String {
        return UUID.randomUUID().toString().replace("-", "");
    }

    fun getIP(request: HttpServletRequest): String {
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

    fun getUserByJson(jsonBody: String): Map<String, String> {
        val map = JSON.parse(jsonBody) as Map<*, *>;
        val dataMap = map["alipay_user_info_share_response"] as Map<*, *>;
        return dataMap as Map<String, String>;
    }

    fun getToken(user: TTcUserRecord, ip: String, jwtId: String): String {
        val signatureAlgorithm = SignatureAlgorithm.HS256
        val nowMillis = System.currentTimeMillis()
        val now = Date(nowMillis)
        val apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key)
        val signingKey: Key = SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.jcaName)
        val builder = Jwts.builder().setId(jwtId).setSubject(subject).setIssuer(issuer).setIssuedAt(now).claim("userId", user.userId)
                .claim("aliUserId", user.aliUserId)
                .claim("ip", ip).signWith(signatureAlgorithm, signingKey)
        val expMillis: Long = nowMillis + TTLMillis
        val exp = Date(expMillis)
        builder.setExpiration(exp)
        val tokenString = builder.compact()
        return tokenString;
    }

    fun parseJWt(token: String): Claims {
        return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(key))
                .parseClaimsJws(token).body
    }

    fun validateToken(request: HttpServletRequest, token: String, jwtId: String): Boolean {
        var map = mutableMapOf<String, Any>()
        if (!token.startsWith(TcConstants.pre_token)) {
            return false
        }
        val exToken: String = token.substring(TcConstants.pre_token.length) ?: return false;
        val result = validateToken(parseJWt(exToken), getIP(request), jwtId)
        val sign: Boolean = result["sign"] as Boolean
        return if (sign) {
            val newToken = refreshToken(exToken, jwtId)
            request.setAttribute("sessionId", TcConstants.pre_token + newToken)
            true;
        } else {
            false;
        }
    }

    fun validateToken(claims: Claims, ip: String?, jwtId: String): Map<String, Any> {
        val exJwtId: String = claims.id
        val exSubject = claims.subject
        val exIssuer = claims.issuer
        val exIssuedAt = claims.issuedAt
        val exIp = claims.get("ip")
        val result = mutableMapOf<String, Any>()
        when {
            exJwtId != jwtId -> {
                result.put("code", 1)
                result.put("sign", false)
                result.put("msg", "token无效")
            }
            subject != exSubject -> {
                result.put("code", 2)
                result.put("sign", false)
                result.put("msg", "token无效")
            }
            issuer != exIssuer -> {
                result.put("code", 3)
                result.put("sign", false)
                result.put("msg", "token无效")
            }
            exIp != ip -> {
                result.put("code", 4)
                result.put("sign", false)
                result.put("msg", "token无效")
            }
            null != claims["userId"] && null != claims["aliUserId"] -> {
                val nowMillis: Long = System.currentTimeMillis()
                val expMillis: Long = exIssuedAt.time + TTLMillis
                if (expMillis > nowMillis) {
                    result.put("code", 0)
                    result.put("sign", true)
                    result.put("msg", "token 验证通过")
                } else {
                    result.put("code", 6)
                    result.put("sign", false)
                    result.put("msg", "token无效")
                }
            }
            else -> {
                result.put("code", 5)
                result.put("sign", false)
                result.put("msg", "token无效")
            }
        }
        return result;
    }

    fun refreshToken(oldToken: String, jwtId: String): String {
        val claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(key))
                .parseClaimsJws(oldToken).body
        val ip = claims["ip"].toString()
        val user = TTcUserRecord()
        user.userId = claims["userId"] as String?
        user.aliUserId = claims["aliUserId"] as String?
        return getToken(user, ip, jwtId)
    }

    fun getEndTimeOfDate(date: Date?): Date? {
        if (date == null) {
            return null
        }
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.set(Calendar.HOUR_OF_DAY, 23)
        calendar.set(Calendar.MINUTE, 59)
        calendar.set(Calendar.SECOND, 59)
        return calendar.time
    }

    fun getSessionIdFromCookie(request: HttpServletRequest): String? {
        val cookies: Array<Cookie>? = request.cookies
        if (cookies == null) {
            return null;
        }
        for (cookie in cookies) {
            if (cookie.name == "tc_session_id") {
                return cookie.value
            }
        }
        return null;
    }

    fun addSessionIdToCookie(response: HttpServletResponse, sessionId: String) {
        val cookie = Cookie("tc_session_id", sessionId)
        response.addCookie(cookie)
    }
}