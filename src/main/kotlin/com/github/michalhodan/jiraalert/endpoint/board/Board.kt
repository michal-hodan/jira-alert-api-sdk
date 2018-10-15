package com.github.michalhodan.jiraalert.endpoint.board

import com.github.michalhodan.jiraalert.endpoint.Rest
import com.github.michalhodan.jiraalert.http.client.IApiClient
import com.github.michalhodan.jiraalert.http.request.Request
import com.github.michalhodan.jiraalert.parser.IJsonParser

class Board(client: IApiClient, parser: IJsonParser): Rest.Agile(client, parser) {

    override val endpoint = "board"

    suspend fun get(id: Int) = client.get(id).deserialize<Board>()

    suspend fun all() = client.get().deserialize<Boards>()

    private suspend fun IApiClient.get(id: Int) = request(Request.get("$path/$id"))

    data class Boards(val values: List<Board>)

    data class Board(
        val id: Int,
        val name: String,
        val type: String
    )
}