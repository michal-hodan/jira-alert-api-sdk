package com.github.michalhodan.jiraalert.endpoint.board

import kotlin.collections.List as KList
import com.github.michalhodan.jiraalert.endpoint.Rest
import com.github.michalhodan.jiraalert.http.client.IApiClient
import com.github.michalhodan.jiraalert.parser.IJsonParser

class Sprint(client: IApiClient, parser: IJsonParser, board: Board.Response) : Rest.Agile(client, parser) {

    override val endpoint = "board/${board.id}/sprint"

    suspend fun all() = client.get().deserialize<List>()

    data class List(val values: KList<Response>)

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