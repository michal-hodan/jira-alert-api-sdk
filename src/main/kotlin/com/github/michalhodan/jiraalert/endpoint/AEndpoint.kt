package com.github.michalhodan.jiraalert.endpoint

import com.github.michalhodan.jiraalert.http.client.IApiClient
import com.github.michalhodan.jiraalert.http.request.Request
import com.github.michalhodan.jiraalert.parser.IParser

abstract class AEndpoint(protected val client: IApiClient, protected val parser: IParser) {

    protected abstract val endpoint: String

    private val path get() = AEndpoint.BASE_PATH + endpoint

    companion object {
        const val BASE_PATH = "rest/api/2/"
    }

    protected suspend fun IApiClient.get() = client.request(Request.get(path))

    protected suspend fun IApiClient.post() = client.request(Request.post(path))
}