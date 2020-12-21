package com.location.location_media

import com.location.location_media.data.Location
import com.location.location_media.data.User
import com.location.location_media.service.redis_service.RedisService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDateTime

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

    @Test
    fun test_set_map() {
        redisService.setMap("4", "location", Location(latitude = 100.0, longitude = 200.0, now = LocalDateTime.now()))
    }

    @Test
    fun test_left_push() {
        redisService.leftPush("users", User(id = 1, name = "Jean Liu"))
    }

    @Test
    fun test_range() {
        println(redisService.listRangeAll("ALL_USERS"))
    }

    @Test
    fun test_list_clear() {
        println(redisService.listClear("ALL_USERS"))
    }

}