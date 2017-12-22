package com.kotlin.zcj.tc.tiancai.controller

import com.kotlin.zcj.tc.data.tables.records.TTcUserRecord
import com.kotlin.zcj.tc.tiancai.service.UserService
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import com.alipay.api.AlipayApiException
import com.alipay.api.response.AlipaySystemOauthTokenResponse
import com.alipay.api.request.AlipaySystemOauthTokenRequest
import com.alipay.api.AlipayConstants.APP_ID
import com.alipay.api.DefaultAlipayClient
import com.alipay.api.AlipayClient
import com.kotlin.zcj.tc.tiancai.alipay.config.AlipayConfig
import com.kotlin.zcj.tc.tiancai.utils.TcConstants


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
    fun index(request: HttpServletRequest, response: HttpServletResponse): ModelAndView {
//        val user: TTcUserRecord = userService.load("86e61c732d4242aaadebab031a600191");
//        stringRedis.opsForValue().set(user.userId, user.toString());
//        println(stringRedis.opsForValue().get(user.userId));
        val authCode = request.getParameter("auth_code");
        val scope = request.getParameter("scope");
        val alipayClient = DefaultAlipayClient("https://openapi.alipay.com/gateway.do",AlipayConfig.appId, AlipayConfig.aesKey
        ,"json",AlipayConfig.input_charset,AlipayConfig.publicKey,"RSA2")
        val aliRequest = AlipaySystemOauthTokenRequest()
        aliRequest.code = authCode
        aliRequest.grantType = "authorization_code"
        try {
            val aliResponse = alipayClient.execute(aliRequest)
            if(aliResponse.isSuccess){
                System.out.println("调用成功");
            } else {
                System.out.println("调用失败");
            }
        } catch (e: AlipayApiException) {
            //处理异常
            e.printStackTrace()
        }

        return ModelAndView("index");
    }

}