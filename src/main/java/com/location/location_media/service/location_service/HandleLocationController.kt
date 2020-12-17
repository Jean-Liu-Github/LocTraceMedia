package com.location.location_media.service.location_service

import com.location.location_media.Response
import com.location.location_media.data.User
import com.location.location_media.data.UserLocation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(path = ["/loc-media"], produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
class HandleLocationController {
    @Autowired
    lateinit var handleLocation: HandleLocation

    @PutMapping(value = ["/user/location"])
    fun save(
            @RequestBody userLocation: UserLocation
    ): String {
        handleLocation.saveLocation(userLocation)
        return Response.successJson()
    }

    @GetMapping(value = ["/user/location/list"])
    fun list(
            @RequestParam("user_ids") user_ids: List<Int>
    ): String {
        return Response.dataJson(handleLocation.getLocations(user_ids))
    }

    @GetMapping(value = ["/user/location/one"])
    fun one(
            @RequestParam("user_id") user_id: Int
    ): String {
        return Response.dataJson(handleLocation.getLocations(Arrays.asList(user_id))?.first())
    }
}