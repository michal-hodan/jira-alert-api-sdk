package com.github.michalhodan.jiraalert.endpoint.board

import kotlin.collections.List as KList
import com.github.michalhodan.jiraalert.endpoint.Rest
import com.github.michalhodan.jiraalert.http.client.IApiClient
import com.github.michalhodan.jiraalert.parser.IJsonParser

class Issue(client: IApiClient, parser: IJsonParser, board: Board.Response, sprint: Sprint.Response) : Rest.Agile(client, parser) {

    override val endpoint = "board/${board.id}/sprint/${sprint.id}/issue"

    suspend fun all() = client.get().deserialize<List>()

    data class List(val issues: KList<Response>)

    data class Response(
        val id: Int,
        val key: String,
        val fields: KList<Issue>
    ) {
        data class Issue(
            val tmp: Int
        )
    }

}