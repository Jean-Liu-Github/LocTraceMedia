package com.location.location_media.service.location_service

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.location.location_media.Moshi
import com.location.location_media.data.Location
import com.location.location_media.data.User
import com.location.location_media.data.UserLocation
import com.location.location_media.service.redis_service.RedisService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HandleLocationImpl : HandleLocation {
    @Autowired
    private lateinit var redisService: RedisService

    override fun saveLocation(userLocation: UserLocation) {
        userLocation.hashKeys().forEach {
            redisService.setMap(
                    key = userLocation.user.id.toString(),
                    hashKey = it,
                    value = userLocation.hashValue(it)
            )
        }
    }

    override fun getLocation(user_id: Int): UserLocation? {
        redisService.getMap(user_id.toString(), UserLocation.allowHashKey())?.let {
            if (it as Boolean) {
                return UserLocation(
                        user = redisService.getMap(user_id.toString(), UserLocation.userHashKey()) as User,
                        location = redisService.getMap(user_id.toString(), UserLocation.locationHashKey()) as Location,
                        allow = true
                )
            }
        }
        return null
    }

    override fun updateLocationAllow(key: String, allow: Boolean) {
        redisService.setMap(key, UserLocation.allowHashKey(), allow)
    }

    override fun getLocations(user_ids: List<Int>): List<UserLocation?> {
        return user_ids.map { user_id ->
            getLocation(user_id)
        }
    }
}