package com.location.location_media.service.location_service

import com.location.location_media.data.User
import com.location.location_media.data.UserLocation

interface HandleLocation {
    fun saveLocation(userLocation: UserLocation): Unit
    fun getLocation(user_id: Int): UserLocation?
    fun updateLocationAllow(key: String, allow: Boolean): Unit
    fun getLocations(user_ids: List<Int>): List<UserLocation?>
}