package com.github.michalhodan.jiraalert.endpoint.issuetype

import kotlin.collections.List as KList
import com.github.michalhodan.jiraalert.endpoint.Rest
import com.github.michalhodan.jiraalert.http.client.IApiClient
import com.github.michalhodan.jiraalert.parser.IJsonParser

class IssueType(client: IApiClient, parser: IJsonParser) : Rest.Api(client, parser) {

    override val endpoint = "issuetype"

    suspend fun get() = client.get().deserialize<KList<Response>>()

    data class Response(
        val id: Int,
        val name: String,
        val description: String,
        val iconUrl: String
    )
}