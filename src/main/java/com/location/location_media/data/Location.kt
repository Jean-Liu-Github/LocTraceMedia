package com.location.location_media.data

import com.squareup.moshi.JsonClass
import java.io.Serializable
import java.time.LocalDate

@JsonClass(generateAdapter = true)
data class Location(
        var longitude: Double,
        var latitude: Double,
        var now: LocalDate
): Serializable {

}