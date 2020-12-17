package com.location.location_media.data

import java.io.Serializable
import java.time.LocalDateTime


data class Location(
        var longitude: Double,
        var latitude: Double,
        var now: LocalDateTime
) : Serializable