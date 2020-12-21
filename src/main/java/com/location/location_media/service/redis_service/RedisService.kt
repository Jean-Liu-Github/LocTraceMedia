package com.location.location_media.service.redis_service

interface RedisService {
    fun <T> setNX(key: String, value: T): Unit
    fun <T> set(key: String, value: T): Unit
    fun getVal(key: String): Any?
    fun delete(key: String): Unit

    fun getMap(key: String, hashKey: String): Any?
    fun <T> setMap(key: String, hashKey: String, value: T): Unit

    fun <T> leftPush(key: String, value: T): Unit
    fun rightPop(key: String): Any?
    fun listRangeAll(key: String): List<Any?>
    fun listSize(key: String): Int
    fun listClear(key: String): Int

    fun <T> geoAdd(key: String, member: String, longitude: Double, latitude: Double)
}