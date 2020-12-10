package com.location.location_media

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlin.reflect.KClass

class Moshi {
    companion object {
        val moshi = Moshi.Builder().build()

        fun <T : Any> toJavaObject(json: String, clazz: KClass<T>): T? {
            return moshi.adapter(clazz.java).fromJson(json)
        }
    }
}