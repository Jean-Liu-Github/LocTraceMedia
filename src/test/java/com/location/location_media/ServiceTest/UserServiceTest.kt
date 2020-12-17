package com.location.location_media.ServiceTest

import com.location.location_media.LocationMediaApplication
import com.location.location_media.data.User
import com.location.location_media.service.user_service.HandleUser
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(value = SpringRunner::class)
@SpringBootTest(classes = [LocationMediaApplication::class])
class UserServiceTest {
    @Autowired
    private lateinit var handleUser: HandleUser

    @Test
    fun test_save_user() {
        handleUser.saveUser(User(id = 1, name = "Jean Liu"))
        handleUser.saveUser(User(id = 2, name = "Yang"))
    }

    @Test
    fun test_get_register_users() {
        println(handleUser.getRegisterUsers())
    }
}