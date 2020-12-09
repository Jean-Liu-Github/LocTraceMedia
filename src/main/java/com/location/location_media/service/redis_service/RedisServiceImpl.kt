package com.location.location_media.service.redis_service

import com.location.location_media.data.UserLocation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class RedisServiceImpl: RedisService {
    @Autowired
    lateinit var redisTemplate : RedisTemplate<String, Any?>

    override fun <T> setNX(
            key : String,
            value : T,
    ) : Unit {
        redisTemplate.opsForValue().setIfAbsent(key, value)
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


}