package com.kotlin.zcj.tc.tiancai.controller

import com.kotlin.zcj.tc.data.tables.records.TTcCorpCodeRecord
import com.kotlin.zcj.tc.tiancai.entity.CorpCodeCondition
import com.kotlin.zcj.tc.tiancai.service.CorpCodeService
import com.kotlin.zcj.tc.tiancai.utils.TcExecutionContext
import com.kotlin.zcj.tc.tiancai.utils.TcUtils
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView
import java.sql.Timestamp
import java.util.*
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest

/**
 * @Since2018/1/21 ZhaCongJie@HF
 */

@Controller
@RequestMapping("/corp")
@RestController
class CorpController {
    @Resource
    lateinit var corpCodeService: CorpCodeService

    @RequestMapping("/toAdd")
    fun toAddCorp(request: HttpServletRequest): ModelAndView {
        return ModelAndView("corp/add")
    }

    @RequestMapping("/add")
    fun add(request: HttpServletRequest, corpCode: CorpCodeCondition): ModelAndView {
        val corpCodeRecord: TTcCorpCodeRecord = genConditionToRecord(corpCode)
        corpCodeService.save(corpCodeRecord)
        return ModelAndView("redirect:toAdd.html")
    }

    private fun genConditionToRecord(corpCode: CorpCodeCondition): TTcCorpCodeRecord {
        val record = TTcCorpCodeRecord()
        record.corpId = corpCode.corpId
        record.corpCode = corpCode.corpCode
        record.link = corpCode.link
        record.introduce = corpCode.introduce
        record.type = corpCode.type
        return record
    }
}
