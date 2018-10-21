package com.github.michalhodan.jiraalert.endpoint.board

import kotlin.collections.List as KList
import com.github.michalhodan.jiraalert.endpoint.Rest
import com.github.michalhodan.jiraalert.http.client.IApiClient
import com.github.michalhodan.jiraalert.parser.IJsonParser

class Configuration(client: IApiClient, parser: IJsonParser, board: Board.Response) : Rest.Agile(client, parser) {

    override val endpoint = "board/${board.id}/configuration"

    suspend fun get() = client.get().deserialize<Response>()

    data class Response(
        val id: Int,
        val name: String,
        val columnConfig: ColumnConfig
    ) {
        data class ColumnConfig(
            val columns: KList<Column>
        ) {
            data class Column(
                val name: String,
                val statuses: KList<Status>,
                val min: Int?,
                val max: Int?
            ) {
                data class Status(
                    val id: Int
                )
            }
        }
    }
}