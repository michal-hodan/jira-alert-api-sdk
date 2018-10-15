package com.github.michalhodan.jiraalert.http.client

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelManager
import com.github.michalhodan.jiraalert.http.Credentials
import com.github.michalhodan.jiraalert.http.request.Request
import com.github.michalhodan.jiraalert.http.response.IResponse
import com.github.michalhodan.jiraalert.http.response.Response
import com.github.michalhodan.jiraalert.http.response.StatusCode

sealed class ApiClient(credentials: Credentials, headers: HashMap<String, String>): IApiClient {

    init {
        FuelManager.instance.apply {
            basePath = credentials.url
            baseHeaders = headers + ("Accept" to "application/json")
        }
    }

    override suspend fun request(request: Request): IResponse {
        val result = when(request) {
            is Request.Get -> Fuel.get(request.path).responseString()
            is Request.Post -> Fuel.post(request.path).responseString()
        }

       return result.run {
           Response(
               statusCode = StatusCode.valueOf(second.statusCode) ?: StatusCode.UNKNOWN,
               headers = second.headers,
               body = third.get()
           )
       }
    }

    class Basic(credentials: Credentials):
        ApiClient(credentials, hashMapOf("Authorization" to "Basic ${credentials.authToken}"))
}