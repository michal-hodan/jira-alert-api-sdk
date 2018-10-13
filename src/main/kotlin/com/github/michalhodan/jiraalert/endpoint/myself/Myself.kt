package com.github.michalhodan.jiraalert.endpoint.myself

import kotlinx.coroutines.runBlocking
import com.github.michalhodan.jiraalert.endpoint.AEndpoint
import com.github.michalhodan.jiraalert.parser.IJsonParser
import com.github.michalhodan.jiraalert.http.client.IApiClient

class Myself(client: IApiClient, parser: IJsonParser): AEndpoint(client, parser) {

    override val endpoint = "myself"

    fun test() = runBlocking {

        val response = client.get()

    }

    data class Response(val id: String) {

    }
}