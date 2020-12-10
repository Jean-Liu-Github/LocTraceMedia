package com.location.location_media.data

import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class UserLocation(
        var user: User,
        var location: Location,
): Serializable