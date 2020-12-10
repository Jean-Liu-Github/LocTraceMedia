package com.location.location_media.data

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.ser.Serializers
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class User(
        var id: Int,
        var name: String,
): Serializable {
}