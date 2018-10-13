package com.github.michalhodan.jiraalert.http.client

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelManager
import com.github.michalhodan.jiraalert.http.Credentials
import com.github.michalhodan.jiraalert.http.request.Request
import com.github.michalhodan.jiraalert.http.response.IResponse
import com.github.michalhodan.jiraalert.http.response.Response
import com.github.michalhodan.jiraalert.http.response.StatusCode

sealed class ApiClient(credentials: Credentials): IApiClient {

    init {
        FuelManager.instance.basePath = credentials.url
    }

    override suspend fun request(request: Request): IResponse {
        val result = when(request) {
            is Request.Get -> Fuel.get(request.path).responseString()
            is Request.Post -> Fuel.post(request.path).responseString()
        }

       return result.second.run {
           Response(
               statusCode = StatusCode.valueOf(statusCode) ?: StatusCode.UNKNOWN,
               headers = headers,
               body = dataStream
           )
       }
    }

    class Basic(credentials: Credentials): ApiClient(credentials) {
        init {
            FuelManager.instance.baseHeaders = mapOf("Authorization" to "Basic ${credentials.authToken}")
        }
    }
}