package com.location.location_media.controller

import com.location.location_media.Response
import com.location.location_media.config.WebSocketConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.handler.TextWebSocketHandler

@RestController
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
class SocketController {
    @Autowired
    lateinit var handler: WebSocketConfig.Handler1

    @RequestMapping("/socket/send")
    fun sendMessage(@RequestParam text: String) : String {
        val message = TextMessage(text)
        val hasSend = handler.sendMessageToUser(1, message)
        val return_mes = if (hasSend) "发送成功" else "发送失败"
        return Response.dataJson(return_mes)
    }
}