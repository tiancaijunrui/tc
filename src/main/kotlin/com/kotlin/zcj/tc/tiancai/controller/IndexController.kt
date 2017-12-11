package com.kotlin.zcj.tc.tiancai.controller

import com.kotlin.zcj.tc.data.tables.records.TTcUserRecord
import com.kotlin.zcj.tc.tiancai.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView
import javax.annotation.Resource

/**
 * @Since2017/12/9 ZhaCongJie@HF
 */
@Controller
@RequestMapping("/index")
class IndexController {
    @Resource
    lateinit var userService: UserService

    @RequestMapping("/index")
    @ResponseBody
    fun index(): ModelAndView {
        val user : TTcUserRecord = userService.load("86e61c732d4242aaadebab031a600191");
        return ModelAndView("index");
    }

}