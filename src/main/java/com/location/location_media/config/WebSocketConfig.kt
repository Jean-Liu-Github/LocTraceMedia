package com.location.location_media.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.*
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry
import org.springframework.web.socket.handler.TextWebSocketHandler

@Configuration
@EnableWebSocket
open class WebSocketConfig : WebSocketConfigurer {
    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(webSocketHandler(), "/api/websocket").setAllowedOrigins("*")
    }

    @Bean
    open fun webSocketHandler() : Handler1 {
        return Handler1()
    }

    class Handler1 : TextWebSocketHandler() {

        companion object {
            val users = mutableMapOf<Int, WebSocketSession>()
        }

        fun sendMessageToUser(user_id: Int, message: TextMessage) : Boolean {
            val session = users.get(user_id) ?: return false

            if (!session.isOpen) return false
            session.sendMessage(message)
            return true
        }

        override fun afterConnectionEstablished(session: WebSocketSession) {
            super.afterConnectionEstablished(session)
            println("服务器建立连接 ......")
        }

        override fun handleMessage(session: WebSocketSession, message: WebSocketMessage<*>) {
            super.handleMessage(session, message)

            println("服务器收到消息: ${message.payload}")
            session.sendMessage(TextMessage("Hello World"))
        }

        override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
            super.afterConnectionClosed(session, status)
            println("服务器断开连接 ......")
        }

    }
}