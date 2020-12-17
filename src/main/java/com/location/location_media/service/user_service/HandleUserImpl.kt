package com.location.location_media.service.user_service

import com.location.location_media.data.User
import com.location.location_media.service.redis_service.RedisService
import com.location.location_media.util.JSON
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HandleUserImpl : HandleUser {
    private val ALL_USERS = "ALL_USERS"
    @Autowired
    private lateinit var redisService : RedisService

    override fun saveUser(user: User) {
        redisService.leftPush(ALL_USERS, user)
    }

    override fun getRegisterUsers(): List<User?> {
        return redisService.listRangeAll(ALL_USERS).map { it?.let {
            JSON.toObject(it, User::class)
        } }
    }
}