package com.kotlin.zcj.tc.tiancai

import javafx.application.Application
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.autoconfigure.session.SessionProperties
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.junit4.SpringRunner
import javax.annotation.Resource
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.StringRedisTemplate


@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(Application::class))
class TiancaiApplicationTests {
    @Resource
    lateinit var redis: StringRedisTemplate;
    @Resource
    private lateinit var redisTem: RedisTemplate<Any, Any>;
    @Test
    fun contextLoads() {
        // 保存字符串
//		redis..set("aaa", "111");
//		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    fun test() {
        redis.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", redis.opsForValue().get("aaa"));
    }


}
