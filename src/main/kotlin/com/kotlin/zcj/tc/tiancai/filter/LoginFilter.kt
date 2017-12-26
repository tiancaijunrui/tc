package com.kotlin.zcj.tc.tiancai.filter

import com.kotlin.zcj.tc.tiancai.service.UserService
import com.kotlin.zcj.tc.tiancai.utils.TcUtils
import org.apache.catalina.connector.RequestFacade
import org.springframework.core.annotation.Order
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.web.context.support.WebApplicationContextUtils
import java.util.concurrent.TimeUnit
import javax.annotation.Resource
import javax.servlet.*
import javax.servlet.annotation.WebFilter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @Since2017/12/18 ZhaCongJie@HF
 */
@Order(1)
@WebFilter(filterName = "loginFilter", urlPatterns = arrayOf("/index/*"))
class LoginFilter : Filter {
    @Resource
    lateinit private var userService: UserService
    @Resource
    lateinit private var stringRedis: StringRedisTemplate;

    private val authUrl = "/login/auth.html"
    override fun destroy() {
    }

    override fun doFilter(req: ServletRequest?, res: ServletResponse?, chain: FilterChain?) {
        val request = req as HttpServletRequest
        val response = res as HttpServletResponse
        val requestUri = request.requestURI
        if (requestUri.contains("index.html")) {
            chain!!.doFilter(request, response);
            return;
        }
        val sessionId = request.getParameter("sessionId")
        val token = stringRedis.opsForValue().get(sessionId)
        val sign = TcUtils.validateToken(request, token, userService.getTokenVersion());
        if (sign) {
            val newToken: String = request.getAttribute("sessionId") as String
            stringRedis.opsForValue().getAndSet(sessionId, newToken)
            stringRedis.expire(sessionId, 60 * 60, TimeUnit.MILLISECONDS)
            chain!!.doFilter(request, response);
        } else {
            response.sendRedirect(authUrl)
        }

    }


    override fun init(filterConfig: FilterConfig?) {
    }

}