package com.location.location_media

import com.location.location_media.service.redis_service.RedisService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(value = SpringRunner::class)
@SpringBootTest(classes = [LocationMediaApplication::class])
class RedisServiceTest {
    @Autowired
    lateinit var redisService: RedisService

    @Test
    fun test_setNx() {
        redisService.setNX("me", "Jean Liu")
    }

    @Test
    fun test_get() {
        println(redisService.getVal("me"))
        assert(redisService.getVal("me") == "Jean Liu")
    }

    @Test
    fun test_delete() {
        redisService.delete("me")
        assert(redisService.getVal("me") == null)
    }
}