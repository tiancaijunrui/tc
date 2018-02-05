package com.kotlin.zcj.tc.tiancai.controller

import com.auth0.jwt.internal.org.apache.commons.lang3.BooleanUtils
import com.kotlin.zcj.tc.tiancai.utils.TcUtils
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Controller
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @Since2018/2/5 ZhaCongJie@HF
 */
@Controller
class DefaultController {
    @Resource
    lateinit private var stringRedis: StringRedisTemplate;

    @RequestMapping("/")
    fun index(request: HttpServletRequest, response: HttpServletResponse): ModelAndView {
        var sessionId: String? = request.getParameter("sessionId")
        if (StringUtils.isEmpty(sessionId)) {
            sessionId = TcUtils.getSessionIdFromCookie(request);
        }
        if (!StringUtils.isEmpty(sessionId) && BooleanUtils.isTrue(stringRedis.hasKey(sessionId))) {
            response.sendRedirect("/index/index.html")
        }
        return ModelAndView("uc/login");
    }

}