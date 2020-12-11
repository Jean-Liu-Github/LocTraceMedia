package com.location.location_media.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
        @Json(name = "id") var id: Int,
        @Json(name = "name") var name: String,
)