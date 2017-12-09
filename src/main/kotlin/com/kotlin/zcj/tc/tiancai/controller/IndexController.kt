package com.kotlin.zcj.tc.tiancai.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView

/**
 * @Since2017/12/9 ZhaCongJie@HF
 */
@Controller
@RequestMapping("/index")
class IndexController {
    @RequestMapping("/index")
    @ResponseBody
    fun index(): ModelAndView {
        return ModelAndView("index");
    }

}