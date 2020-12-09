package com.location.location_media.service.redis_service

interface RedisService {
    fun <T> setNX(key: String, value: T): Unit
    fun getVal(key: String): Any?
    fun delete(key: String): Unit
}