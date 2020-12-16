package com.location.location_media.ServiceTest

import com.alibaba.fastjson.JSON
import com.location.location_media.LocationMediaApplication
import com.location.location_media.data.Location
import com.location.location_media.data.User
import com.location.location_media.data.UserLocation
import com.location.location_media.service.location_service.HandleLocation
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDate
import java.time.LocalDateTime

@RunWith(value = SpringRunner::class)
@SpringBootTest(classes = [LocationMediaApplication::class])
class LocationServiceTest {
    @Autowired
    private lateinit var handleLocation : HandleLocation

    @Test
    fun saveUserLocation() {
        val userLocation = UserLocation(
                user = User(id = 1, name = "Jean Liu"),
                location = Location(latitude = 100.0, longitude = 200.0, now = LocalDateTime.now())
        )

        handleLocation.saveLocation(userLocation)
    }

    @Test
    fun getUserLocation() {
        println(JSON.toJSONString(handleLocation.getLocation(1)))
    }
}