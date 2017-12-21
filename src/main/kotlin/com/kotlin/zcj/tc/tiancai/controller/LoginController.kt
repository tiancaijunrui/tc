package com.kotlin.zcj.tc.tiancai.controller

import com.kotlin.zcj.tc.tiancai.alipay.config.AlipayConfig
import com.kotlin.zcj.tc.tiancai.alipay.util.AlipaySubmit
import com.kotlin.zcj.tc.tiancai.utils.TcConstants
import com.kotlin.zcj.tc.tiancai.utils.TcUtils
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView
import java.util.*
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @Since2017/12/19 ZhaCongJie@HF
 */
@Controller
@RequestMapping("/login")
class LoginController {
    @Resource
    lateinit private var stringRedis: StringRedisTemplate;

    @RequestMapping("/login.html")
    @ResponseBody
    fun toLogin(request: HttpServletRequest): ModelAndView {
//        val anti_phishing_key = AlipaySubmit.query_timestamp();
//        val exter_invoke_ip = TcUtils.getIP(request);
//        val sParaTemp = mutableMapOf<String, String?>();
//        sParaTemp.put("service", "alipay.auth.authorize");
//        sParaTemp.put("partner", AlipayConfig.partner);
//        sParaTemp.put("target_service", TcConstants.target_service);
//        sParaTemp.put("return_url", TcConstants.return_url);
////        sParaTemp.put("_input_charset",AlipayConfig.input_charset);
////        sParaTemp.put("sign_type",AlipayConfig.sign_type);
//
////        sParaTemp.put("anti_phishing_key", anti_phishing_key);
////        sParaTemp.put("exter_invoke_ip", exter_invoke_ip);
//        val sHtmlText = AlipaySubmit.buildRequest(sParaTemp, "get", "确认");
//        request.setAttribute("sHtmlText", sHtmlText);

        return ModelAndView("uc/login");
    }

    @RequestMapping("/auth.html")
    @ResponseBody
    fun toAuth(response : HttpServletResponse ){
        val sParaTemp = mutableMapOf<String, String?>();
        sParaTemp.put("app_id", AlipayConfig.appId);
        sParaTemp.put("scope", TcConstants.scope);
        sParaTemp.put("redirect_uri", TcConstants.redirect_uri);
        val uuId = TcUtils.genUUID();
        stringRedis.opsForValue().set(uuId, System.currentTimeMillis().toString());
        sParaTemp.put("state", uuId);
        val url = AlipaySubmit.getAlipayAuthUrl(sParaTemp);
        response.sendRedirect(url);
    }
}