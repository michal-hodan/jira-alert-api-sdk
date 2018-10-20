package com.github.michalhodan.jiraalert.endpoint.board

import com.github.michalhodan.jiraalert.endpoint.Rest
import com.github.michalhodan.jiraalert.http.client.IApiClient
import com.github.michalhodan.jiraalert.parser.IJsonParser

class Sprint(client: IApiClient, parser: IJsonParser, board: Board.Response) : Rest.Agile(client, parser) {

    override val endpoint = "board/${board.id}/sprint"

    suspend fun all() = client.get().deserialize<List>()

    suspend fun get(id: Int) = client.get(id).deserialize<Response>()

    data class List(val results: kotlin.collections.List<Response>)

    data class Response(
        val id: Int,
        val state: String,
        val name: String,
        val goal: String,
        val startDate: String?,
        val endDate: String?,
        val completeDate: String?
    )
}