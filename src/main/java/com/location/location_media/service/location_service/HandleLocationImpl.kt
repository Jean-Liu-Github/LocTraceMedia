package com.location.location_media.service.location_service

import com.alibaba.fastjson.JSON
import com.location.location_media.data.User
import com.location.location_media.data.UserLocation
import com.location.location_media.service.redis_service.RedisService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HandleLocationImpl: HandleLocation {
    @Autowired
    private lateinit var redisService : RedisService

    override fun saveLocation(userLocation: UserLocation) {
        redisService.setNX(userLocation.user.id.toString(), userLocation)
    }

    override fun getLocationByUsers(users: List<User>): List<UserLocation> {
        return users.map{redisService.getVal(it.id.toString())} as List<UserLocation>
    }
}