package com.github.michalhodan.jiraalert.endpoint.myself

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.github.michalhodan.jiraalert.endpoint.AEndpoint
import com.github.michalhodan.jiraalert.parser.IJsonParser
import com.github.michalhodan.jiraalert.http.client.IApiClient
import com.github.michalhodan.jiraalert.http.response.IResponse

class Myself(client: IApiClient, parser: IJsonParser): AEndpoint(client, parser) {

    override val endpoint = "myself"

    suspend fun get() = client.get().deserialize<Response>()

    private inline fun <reified T: Any>IResponse.deserialize() = parser.deserialize(this.body, T::class)

    @JsonIgnoreProperties(ignoreUnknown = true)
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