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

    data class Response(
        val name: String,
        val displayName: String,
        val emailAddress: String,
        val locale: String,
        val timeZone: String,
        val avatarUrls: AvatarUrl
    ) {
        data class AvatarUrl(
            val `48x48`: String,
            val `32x32`: String,
            val `24x24`: String,
            val `16x16`: String
        )
    }
}