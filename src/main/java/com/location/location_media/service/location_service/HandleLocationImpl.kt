package com.location.location_media.service.location_service

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.location.location_media.Moshi
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
        redisService.setNX(userLocation.user.id.toString(), JSON.toJSONString(userLocation))
    }

    override fun getLocationsByUsers(user_ids: List<Int>): List<UserLocation?> {
        return user_ids.map { user_id ->
            redisService.getVal(user_id.toString())?.let {
                Moshi.toJavaObject(it as String, UserLocation::class)
            }
        }
    }
}