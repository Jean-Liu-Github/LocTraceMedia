package com.location.location_media.data

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.squareup.moshi.JsonClass
import java.io.Serializable
import java.time.LocalDate

@JsonClass(generateAdapter = true)
@JsonSerialize
data class Location(
        var longitude: Double,
        var latitude: Double,
        var now: LocalDate
)