package com.location.location_media.service.location_service

import com.location.location_media.data.User
import com.location.location_media.data.UserLocation
import org.springframework.stereotype.Service

@Service
class HandleLocationImpl: HandleLocation {
    override fun saveLocation(myLocation: UserLocation) {

    }

    override fun getLocationByUsers(users: List<User>): List<UserLocation> {
        return listOf(UserLocation())
    }
}