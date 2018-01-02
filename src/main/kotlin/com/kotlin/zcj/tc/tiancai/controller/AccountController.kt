package com.kotlin.zcj.tc.tiancai.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest

/**
 * @Since2017/12/30 ZhaCongJie@HF
 */
@Controller
@RequestMapping("/ac")
class AccountController {
    @RequestMapping("/toAdd.html")
    fun toAddAccount(request: HttpServletRequest) : ModelAndView {
        return ModelAndView("account/add")
    }
}