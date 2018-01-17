package com.kotlin.zcj.tc.tiancai.controller

import com.kotlin.zcj.tc.data.tables.records.TTcAccountRecord
import com.kotlin.zcj.tc.tiancai.entity.AccountCondition
import com.kotlin.zcj.tc.tiancai.entity.Page
import com.kotlin.zcj.tc.tiancai.service.AccountService
import com.kotlin.zcj.tc.tiancai.service.CorpCodeService
import org.springframework.stereotype.Controller
import org.springframework.util.StringUtils
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest
import javax.validation.Valid


/**
 * @Since2017/12/30 ZhaCongJie@HF
 */
@Controller
@RequestMapping("/ac")
@RestController
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

    @RequestMapping("/toUpdate.html")
    fun toUpdate(request: HttpServletRequest): ModelAndView {
        request.setAttribute("corpCodeList", corpCodeService.listCorp())
        val accountId: String? = request.getParameter("accountId");
        request.setAttribute("account", accountId?.let { accountService.getByAccountId(it) })
        return ModelAndView("account/update");
    }

    @RequestMapping("/update.html")
    fun update(request: HttpServletRequest, @Valid accountCondition: AccountCondition, bindingResult: BindingResult): MutableMap<String, Any> {
        val dataMap = mutableMapOf<String, Any>()
        if (bindingResult.hasErrors()) {
            dataMap["status"] = "error"
            dataMap["msg"] = bindingResult.fieldErrors[0].defaultMessage
            return dataMap;
        }
        accountService.update(accountCondition)
        dataMap["status"] = "success"
        return dataMap
    }

    @PostMapping("/loadAccount.html")
    fun loadAccount(request: HttpServletRequest, @Valid accountCondition: AccountCondition?, bindingResult: BindingResult): MutableMap<String, Any> {
        val dataMap = mutableMapOf<String, Any>()
        val exAccountCondition = AccountCondition()
        if (accountCondition == null) {
            val page = accountService.pageAccount(exAccountCondition, accountCondition!!.page)
            page?.let { dataMap.put("data", page.data) }
            page?.total?.let { dataMap.put("count", it) }
        } else {
            val page = accountService.pageAccount(accountCondition, accountCondition.page)
            page?.let { dataMap.put("data", page.data) }
            page?.total?.let { dataMap.put("count", it) }
        }
        dataMap.put("status", "success")
        dataMap.put("code", 0)
        return dataMap;

    }
}