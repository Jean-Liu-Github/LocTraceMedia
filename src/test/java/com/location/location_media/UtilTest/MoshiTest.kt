package com.location.location_media.UtilTest

import com.alibaba.fastjson.JSON
import com.location.location_media.LocationMediaApplication
import com.location.location_media.Moshi
import com.location.location_media.data.Location
import com.location.location_media.data.User
import com.location.location_media.data.UserLocation
import com.location.location_media.service.redis_service.RedisService
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDate
import java.time.LocalDateTime

@RunWith(value = SpringRunner::class)
@SpringBootTest(classes = [LocationMediaApplication::class])
class MoshiTest {
    @Autowired
    lateinit var redisService: RedisService

    @Test
    fun moshiFromJson() {
        val user = User(id = 1, name = "Jean Liu")
        println(Moshi.toJson(user, User::class))
        val user2 = Moshi.fromJson(Moshi.toJson(user, User::class), User::class)
        println(Moshi.toJson(user2!!, User::class))
    }

    @Test
    fun moshiToJson() {
        val user = User(id = 1, name = "Jean Liu")
        /** 记得添加KotlinJsonAdapterFactory **/
        val moshi = com.squareup.moshi.Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        println(moshi.adapter(User::class.java).toJson(user))
//        println(Moshi.toJson(user, User::class))
    }

    @Test
    fun last() {
        println("abcdid".lastIndexOf("id").toString() +"abcdid"[4])
    }

    @Test
    fun setRedis() {
        val user = User(id = 1, name = "Jean Liu")
        redisService.set("me", Moshi.toJson(user, User::class))
    }

    @Test
    fun getFromRedis() {
        println(Moshi.fromJson(redisService.getVal("me") as String, User::class))
    }

    @Test
    fun test() {
        val user = User(id = 1, name = "Jean Liu")
        val Location = Location(latitude = 30.0, longitude = 40.0, now = LocalDateTime.now())
        val userLocation = UserLocation(user = user, location = Location)
        val string = JSON.toJSONString(userLocation)
//        val jsonUser = JSON.parseObject(JSON.toJSONString(user))
        val user2 = JSON.parseObject(string, UserLocation::class.java)
        println(user2)
    }
}