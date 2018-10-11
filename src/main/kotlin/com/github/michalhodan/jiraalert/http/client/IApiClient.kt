package com.github.michalhodan.jiraalert.http.client

import com.monkeydata.jiraalert.http.request.Request

interface IApiClient {

    suspend fun request(request: Request)
}