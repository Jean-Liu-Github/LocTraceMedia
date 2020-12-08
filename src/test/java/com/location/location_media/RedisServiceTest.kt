package com.location.location_media

import com.location.location_media.service.redis_service.RedisService
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(value = SpringRunner::class)
@SpringBootTest(classes = arrayOf(LocationMediaApplication::class))
class RedisServiceTest {
    @Autowired
    lateinit var redisService: RedisService

    fun test_redis() {
        redisService.hashOps()
    }
}