package com.location.location_media.data

import com.alibaba.fastjson.annotation.JSONField
import java.io.Serializable

data class UserLocation (
        var user: User,
        var location: Location,
        var allow: Boolean = true,
) : Serializable {

    fun hashValue(hashKey: String): Any? {
        return when(hashKey) {
            "user" -> user
            "location" -> location
            "allow" -> allow
            else -> null
        }
    }

    fun hashKeys(): Array<String> {
        return arrayOf("user", "location", "allow")
    }

    companion object {
        fun userHashKey(): String {
            return "user";
        }

        fun locationHashKey(): String {
            return "location";
        }

        fun allowHashKey(): String {
            return "allow";
        }
    }
}