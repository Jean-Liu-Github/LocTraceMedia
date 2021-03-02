package com.location.location_media.data

import com.alibaba.fastjson.annotation.JSONField
import java.io.Serializable
import java.time.LocalDateTime


data class Location(
        var longitude: Double,
        var latitude: Double,
        @JSONField(format = "yyyy-MM-dd HH:mm:ss")
        var now: LocalDateTime
) : Serializable