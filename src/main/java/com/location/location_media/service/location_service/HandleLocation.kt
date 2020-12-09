package com.location.location_media.service.location_service

import com.location.location_media.data.User
import com.location.location_media.data.UserLocation

interface HandleLocation {
    fun saveLocation(userLocation: UserLocation)

    fun getLocationByUsers(users: List<User>): List<UserLocation>
}