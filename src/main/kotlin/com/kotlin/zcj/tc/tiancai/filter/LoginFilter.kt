package com.kotlin.zcj.tc.tiancai.filter

import org.apache.catalina.connector.RequestFacade
import org.springframework.core.annotation.Order
import javax.servlet.*
import javax.servlet.annotation.WebFilter

/**
 * @Since2017/12/18 ZhaCongJie@HF
 */
@Order(1)
@WebFilter(filterName = "loginFilter",urlPatterns = arrayOf("/index/*"))
class LoginFilter : Filter {
    override fun destroy() {
    }

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        println((request as RequestFacade).requestURI);
        var token = request.getHeader("token");
        chain!!.doFilter(request,response);
    }

    override fun init(p0: FilterConfig?) {
    }

}