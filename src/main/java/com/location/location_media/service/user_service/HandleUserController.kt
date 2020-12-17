package com.location.location_media.service.user_service

import com.location.location_media.Response
import com.location.location_media.data.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/loc-media"])
class HandleUserController {
    @Autowired
    private lateinit var handleUser: HandleUser

    @PostMapping(value = ["/user"])
    fun saveUser(@RequestBody user: User): String {
        handleUser.saveUser(user)
        return Response.successJson()
    }

    @GetMapping(value = ["/user/all"])
    fun getRegisterUser(): String {
        return Response.dataJson(handleUser.getRegisterUsers())
    }
}