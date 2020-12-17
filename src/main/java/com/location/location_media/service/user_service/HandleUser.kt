package com.location.location_media.service.user_service

import com.location.location_media.data.User

interface HandleUser {
    fun saveUser(user: User): Unit
    fun getRegisterUsers(): List<User?>
}