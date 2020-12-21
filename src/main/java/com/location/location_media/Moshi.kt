package com.location.location_media

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlin.reflect.KClass

object Moshi {
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    fun <T : Any> fromJson(json: String, kotlinClass: KClass<T>): T? {
        return moshi.adapter(kotlinClass.java).fromJson(json)
    }

    fun <T : Any> toJson(obj: T, kotlinClass: KClass<T>): String {
        return moshi.adapter(kotlinClass.java).toJson(obj)
    }
}