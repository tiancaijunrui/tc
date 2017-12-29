package com.kotlin.zcj.tc.tiancai.utils

import org.junit.Test
import java.io.File

/**
 * @Since2017/12/28 ZhaCongJie@HF
 */
class ReaderFileTest{
    @Test
    fun test1(){
        val filename = """C:\Users\tiancaijunrui\Desktop\catalina.out"""
        val file = File(filename)
//        val contents = file.readText()
//        println(contents)
        val startList = mutableListOf<String>()
        val endList = mutableListOf<String>()
        //大写前三行
        file.readLines().forEach {
            if (it.contains("_fixGetScoreTime start")){
                startList.add(it.substring(0,it.indexOf("_fixGetScoreTime start")))
            }
            if (it.contains("_fixGetScoreTime end")){
                endList.add(it.substring(0,it.indexOf("_fixGetScoreTime end")))
            }

        }
        for(corpCode in startList){
            println("'"+corpCode.substring(corpCode.lastIndexOf("=")+1)+"',")
        }
        println("=============================================")
        startList.removeAll(endList)
        for(corpCode in startList){
            println("'"+corpCode.substring(corpCode.lastIndexOf("=")+1)+"',")
        }
//        println(startList)

    }
}