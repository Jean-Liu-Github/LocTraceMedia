package com.location.location_media.data

import com.squareup.moshi.Json
import java.io.Serializable

data class User(
        @Json(name = "id") var id: Int,
        @Json(name = "name") var name: String,
) : Serializable