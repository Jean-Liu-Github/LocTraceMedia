package com.location.location_media.data

import java.time.LocalDate

data class Location(
        var longitude: Double,
        var latitude: Double,
        var now: LocalDate
) {
}