package com.kotlin.zcj.tc.tiancai.controller

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest


/**
 * @Since2018/2/4 ZhaCongJie@HF
 */
@ControllerAdvice
class DefaultExceptionController{
    val DEFAULT_ERROR_VIEW = "error"

    @ExceptionHandler(value = [(Exception::class)])
    @Throws(Exception::class)
    fun defaultErrorHandler(req: HttpServletRequest, e: Exception): ModelAndView {
        val mav = ModelAndView()
        mav.addObject("exception", e)
        mav.addObject("url", req.getRequestURL())
        mav.viewName = DEFAULT_ERROR_VIEW
        return mav
    }
}