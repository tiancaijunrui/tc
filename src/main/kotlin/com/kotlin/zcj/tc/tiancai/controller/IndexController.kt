package com.kotlin.zcj.tc.tiancai.controller

import com.alipay.api.AlipayApiException
import com.alipay.api.DefaultAlipayClient
import com.alipay.api.request.AlipaySystemOauthTokenRequest
import com.alipay.api.request.AlipayUserInfoShareRequest
import com.kotlin.zcj.tc.data.tables.records.TTcUserRecord
import com.kotlin.zcj.tc.tiancai.alipay.config.AlipayConfig
import com.kotlin.zcj.tc.tiancai.service.UserService
import com.kotlin.zcj.tc.tiancai.utils.TcUtils
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Controller
import org.springframework.util.Assert
import org.springframework.util.CollectionUtils
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import kotlin.reflect.jvm.internal.impl.platform.MappingUtilKt


/**
 * @Since2017/12/9 ZhaCongJie@HF
 */
@Controller
@RequestMapping("/index")
class IndexController {
    @Resource
    lateinit private var userService: UserService
    @Resource
    lateinit private var stringRedis: StringRedisTemplate;

    @RequestMapping("/index.html")
    @ResponseBody
    fun index(request: HttpServletRequest, response: HttpServletResponse): ModelAndView? {
        val aliMap = getUserFromAli(request)
        var user: TTcUserRecord? = TTcUserRecord();
        val aliUserId: String? = aliMap["user_id"]
        if (aliUserId == null) {
            response.sendRedirect("/login/auth.html");
            return null;
        }
        user = userService.getUserByAliUserId(aliUserId)
        if (user == null || StringUtils.isEmpty(user.userId)) {
            user = TTcUserRecord()
            user.userId = request.getParameter("state")
            user.aliUserId = aliMap["user_id"]
            user.nickName = aliMap["nick_name"]
            user.avatar = aliMap["avatar"]
            userService.save(user);
        }
        request.setAttribute("user", user)
        return ModelAndView("index");
    }

    private fun getUserFromAli(request: HttpServletRequest): Map<String, String> {
        val authCode = request.getParameter("auth_code")
        val aliPayClient = DefaultAlipayClient("https://openapi.alipay.com/gateway.do", AlipayConfig.appId, AlipayConfig.secretKey
                , "json", AlipayConfig.input_charset, AlipayConfig.publicKey, "RSA2")
        val aliRequest = AlipaySystemOauthTokenRequest()
        aliRequest.code = authCode
        aliRequest.grantType = "authorization_code"
        val aliResponse = aliPayClient.execute(aliRequest)
        if (aliResponse.isSuccess) {
            System.out.println("调用成功");
            val aliRequestTwo = AlipayUserInfoShareRequest()
            val auth_token = aliResponse.accessToken
            try {
                val userinfoShareResponse = aliPayClient.execute(aliRequestTwo, auth_token)
                return TcUtils.getUserByJson(userinfoShareResponse.body)
            } catch (e: AlipayApiException) {
                //处理异常
                e.printStackTrace()
            }
        }
        return HashMap<String, String>(0);
    }

}