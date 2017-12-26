package com.kotlin.zcj.tc.tiancai.utils

import com.kotlin.zcj.tc.data.tables.records.TTcUserRecord
import com.kotlin.zcj.tc.tiancai.service.UserService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

import javax.annotation.Resource
import javax.xml.bind.DatatypeConverter

/**
 * @Since2017/12/26 ZhaCongJie@HF
 */
@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestJWT {
    @Resource
    private val userService: UserService? = null

    @Test
    fun exampleTest() {
        val userId = "8e3a78871bae47b4b6e9e3e6cb692280"
        val user = userService!!.load(userId)
        println(user.toString())
        val token = TcUtils.getToken(user, "127.0.0.1","11")
        println(token)
        TcUtils.validateToken(TcUtils.parseJWt(token),"127.0.0.1","11")
    }

    @Test
    fun exampleTest1() {
        val token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJiMDYzNzk2NTFkOTk0MzQ5OGUyYzBmNDkwODRiNTBhMCIsInN1YiI6IlRDIiwiaXNzIjoiVEMiLCJpYXQiOjE1MTQyNTEwNTIsInVzZXJJZCI6IjhlM2E3ODg3MWJhZTQ3YjRiNmU5ZTNlNmNiNjkyMjgwIiwiYWxpVXNlcklkIjoiMjA4ODgwMjU0MDEwODYyNCIsImlwIjoiMTI3LjAuMC4xIiwiZXhwIjoxNTE0MjU0NjUyfQ.HpxSdaM-x9TqyqI37U1Nk42yVMdGgZ5vBraWiooFIJA";
        val claims = TcUtils.parseJWt(token)


    }
}
