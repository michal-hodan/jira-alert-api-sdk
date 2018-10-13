package com.github.michalhodan.jiraalert.http.client

import com.github.michalhodan.jiraalert.http.request.Request
import com.github.michalhodan.jiraalert.http.response.IResponse

interface IApiClient {

    suspend fun request(request: Request): IResponse
}