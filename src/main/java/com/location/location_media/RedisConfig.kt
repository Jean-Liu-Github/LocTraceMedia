package com.location.location_media

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate

@Configuration
open class RedisConfig {
    @Bean
    @ConditionalOnMissingBean(name = arrayOf<String>("redisTemplate"))
    open fun redisTemplate(redisConnectionFactory: RedisConnectionFactory): RedisTemplate<String, Any?>{
        return RedisTemplate<String, Any?>()
    }
}