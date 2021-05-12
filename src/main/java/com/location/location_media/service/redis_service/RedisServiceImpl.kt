package com.location.location_media.service.redis_service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.geo.Point
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit
import javax.annotation.Resource

@Service
class RedisServiceImpl : RedisService {
    @Autowired
    lateinit var redisTemplate: RedisTemplate<String, Any?>
//    @Autowired
//    lateinit var redisTemplate2 : RedisTemplate<String, String>

//    @Resource(name = "redisTemplate")
//    val key_value = redisTemplate.opsForValue()
//    @Resource(name = "redisTemplate")
//    val map = redisTemplate.opsForHash<String, Any?>()

    override fun <T> setNX(
            key: String,
            value: T,
    ): Unit {
        redisTemplate.opsForValue().setIfAbsent(key, value)
    }

    override fun <T> set(key: String, value: T) {
        redisTemplate.opsForValue().set(key, redisTemplate.opsForValue())
    }

    override fun getVal(key: String): Any? {
        return redisTemplate.opsForValue().get(key)
    }

    fun <T> setENX(
            key: String,
            value: T,
            timeOut: Long,
            timeUnit: TimeUnit
    ): Unit {
        redisTemplate.opsForValue().setIfAbsent(key, value, timeOut, timeUnit)
    }

    override fun delete(key: String) {
        redisTemplate.delete(key)
    }

    override fun getMap(key: String, hashKey: String): Any? {
        return redisTemplate.opsForHash<String, Any?>()[key, hashKey]
    }

    override fun <T> setMap(key: String, hashKey: String, value: T) {
        redisTemplate.opsForHash<String, Any?>().put(key, hashKey, value)
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

    override fun listRangeAll(key: String): List<Any?> {
        return redisTemplate.opsForList().size(key)?.let {
            redisTemplate.opsForList().range(key, 0, it)
        } ?: emptyList()
    }

    override fun listSize(key: String): Int {
        return redisTemplate.opsForList().size(key)?.toInt() ?: 0
    }

    override fun listClear(key: String): Int {
        val num = listSize(key)
        while (listSize(key) > 0) {
            redisTemplate.opsForList().rightPop(key)
        }
        return num.toInt()
    }

    override fun <T> geoAdd(key: String, member: String, longitude: Double, latitude: Double) {
        redisTemplate.opsForGeo().add(key, Point(latitude, longitude), member)
    }
}