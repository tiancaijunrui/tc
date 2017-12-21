package com.kotlin.zcj.tc.tiancai.utils

import org.junit.Test

/**
 * @Since2017/12/9 ZhaCongJie@HF
 */
class Test1 {
    @Test
    fun testUUID() {
        for(i in 1..10){
            val id = TcUtils.genUUID()
            println(id);
        }


    }

    @Test
    fun testToken(){
//        println(TcUtils.getToken("adfadfsdf",Date()));
    }
}