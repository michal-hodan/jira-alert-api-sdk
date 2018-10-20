package com.github.michalhodan.jiraalert.endpoint.board

import com.github.michalhodan.jiraalert.endpoint.Rest
import com.github.michalhodan.jiraalert.http.client.IApiClient
import com.github.michalhodan.jiraalert.parser.IJsonParser

class Board(client: IApiClient, parser: IJsonParser): Rest.Agile(client, parser) {

    override val endpoint = "board"

    suspend fun get(id: Int) = client.get(id).deserialize<Response>()

    suspend fun all() = client.get().deserialize<List>()

    data class List(val values: kotlin.collections.List<Response>)

    data class Response(
        val id: Int,
        val name: String,
        val type: String
    )
}