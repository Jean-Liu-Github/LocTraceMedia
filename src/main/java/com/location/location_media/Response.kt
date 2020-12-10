package com.location.location_media

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject

class Response {
    companion object {
        fun successJson(): String {
            val successJson = JSONObject()

            successJson.put(key = "code", value = "200")
            successJson.put(key = "mes", value = "Success")

            return JSON.toJSONString(successJson)
        }

        fun <T> dataJson(data: T): String {
            val dataJson = JSONObject()

            dataJson.put(key = "code", value = "200")
            dataJson.put(key = "mes", value = "Success")
            dataJson.put(key = "data", value = data)

            return JSON.toJSONString(dataJson)
        }
    }
}