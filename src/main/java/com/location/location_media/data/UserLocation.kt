package com.location.location_media.data

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
@JsonSerialize
data class UserLocation(
        var user: User,
        var location: Location,
)