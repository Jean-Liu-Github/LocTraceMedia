package com.location.location_media.service.redis_service

import com.location.location_media.Moshi
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.geo.Point
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class RedisServiceImpl: RedisService {
    @Autowired
    lateinit var redisTemplate : RedisTemplate<String, String>

    override fun <T> setNX(
            key : String,
            value : T,
    ) : Unit {
        redisTemplate.opsForValue().setIfAbsent(key, Moshi.toJson(value, T::class))
    }

    override fun <T> set(key: String, value: T) {
        redisTemplate.opsForValue().set(key, value)
    }

    override fun getVal(key: String): Any? {
        return redisTemplate.opsForValue().get(key)
    }

    override fun delete(key: String) {
        redisTemplate.delete(key)
    }

    fun <T> setENX(
            key : String,
            value : T,
            timeOut : Long,
            timeUnit : TimeUnit
    ): Unit {
        redisTemplate.opsForValue().setIfAbsent(key, value, timeOut, timeUnit)
    }

    override fun <T> leftPush(
            key: String,
            value: T
    ) {
        redisTemplate.opsForList().leftPush(key, value)
    }

    override fun rightPop(key: String): Any? {
        return redisTemplate.opsForList().rightPop(key)
    }

    override fun <T> geoAdd(key: String, member: String, longitude: Double, latitude: Double) {
        redisTemplate.opsForGeo().add(key, Point(latitude, longitude), member)
    }



    fun test() {
        redisTemplate.opsForGeo()
    }

}