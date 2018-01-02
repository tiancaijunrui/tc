package com.kotlin.zcj.tc.tiancai.utils

import com.kotlin.zcj.tc.data.tables.records.TTcCorpCodeRecord
import com.kotlin.zcj.tc.tiancai.service.CorpCodeService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import javax.annotation.Resource

/**
 * @Since2018/1/2 ZhaCongJie@HF
 */
@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CorpCodeTest {
    @Resource
    lateinit var corpCodeService: CorpCodeService

    @Test
    fun saveTest() {
        val corpCode = TTcCorpCodeRecord()
        corpCode.corpCode = "战网"
        corpCode.type = "PUBLIC"
        TcExecutionContext.setUserId("8e3a78871bae47b4b6e9e3e6cb692280")
        corpCodeService.save(corpCode)
    }
    @Test
    fun updateTest(){
        val corpCodeList = corpCodeService.listCorp()
        for (corpCode in corpCodeList){
            if (corpCode.corpCode == "网易邮箱"){
                corpCode.link = null
                corpCode.introduce = null
                TcExecutionContext.setUserId("8e3a78871bae47b4b6e9e3e6cb692280")
                corpCodeService.save(corpCode)
            }
        }
        println(corpCodeList.size)
    }
}