package com.kotlin.zcj.tc.tiancai.controller

import com.kotlin.zcj.tc.tiancai.entity.AccountCondition
import com.kotlin.zcj.tc.tiancai.entity.Page
import com.kotlin.zcj.tc.tiancai.service.AccountService
import com.kotlin.zcj.tc.tiancai.service.CorpCodeService
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest
import javax.validation.Valid


/**
 * @Since2017/12/30 ZhaCongJie@HF
 */
@Controller
@RequestMapping("/ac")
class AccountController {
    @Resource
    lateinit var corpCodeService: CorpCodeService
    @Resource
    lateinit var accountService: AccountService


    @RequestMapping("/toAdd.html")
    fun toAddAccount(request: HttpServletRequest): ModelAndView {
        request.setAttribute("corpCodeList", corpCodeService.listCorp())
        return ModelAndView("account/add")
    }

    @RequestMapping("/add.html")
    fun addAccount(request: HttpServletRequest, @Valid accountCondition: AccountCondition, bindingResult: BindingResult): ModelAndView {
        if (bindingResult.hasErrors()) {
            return ModelAndView("redirect:toAdd.html?sessionId=" + request.getAttribute("sessionId"))
        }
        accountService.save(accountCondition)
        return ModelAndView("redirect:toAdd.html?sessionId=" + request.getAttribute("sessionId"))
    }

    @PostMapping("/loadAccount.html")
    fun loadAccount(request: HttpServletRequest, @Valid accountCondition: AccountCondition?, bindingResult: BindingResult): MutableMap<String, Any> {
        val dataMap  = mutableMapOf<String,Any>()
        val exAccountCondition = AccountCondition()
        if (accountCondition == null) {
            val page = accountService.pageAccount(exAccountCondition, accountCondition!!.page)
        }else{
            val page = accountService.pageAccount(accountCondition, accountCondition.page)
        }
        dataMap.put("status", "success")
        return dataMap;

    }
}