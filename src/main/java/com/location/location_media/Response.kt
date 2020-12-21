package com.location.location_media

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject

object Response {
    fun successJson(): String {
        val successJson = JSONObject()

        successJson["code"] = "200"
        successJson["mes"] = "Success"

        return JSON.toJSONString(successJson)
    }

    fun <T> dataJson(data: T): String {
        val dataJson = JSONObject()

        dataJson["code"] = "200"
        dataJson["data"] = data
        dataJson["mes"] = "Success"

        return JSON.toJSONString(dataJson)
    }
}