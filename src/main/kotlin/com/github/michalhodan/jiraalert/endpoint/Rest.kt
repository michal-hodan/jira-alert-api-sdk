package com.github.michalhodan.jiraalert.endpoint

import com.github.michalhodan.jiraalert.http.client.IApiClient
import com.github.michalhodan.jiraalert.http.request.Request
import com.github.michalhodan.jiraalert.http.response.IResponse
import com.github.michalhodan.jiraalert.parser.IJsonParser

sealed class Rest(protected val client: IApiClient, protected val parser: IJsonParser) {

    protected abstract val endpoint: String

    protected abstract val type: Type

    protected val path
        get() = "rest/${type.type}/${type.version}/$endpoint"

    protected enum class Type(val type: String, val version: String) {
        AGILE_1("agile", "1.0"), API_2("api", "2")
    }

    abstract class Agile(client: IApiClient, parser: IJsonParser): Rest(client, parser) {
        override val type = Type.AGILE_1
    }

    abstract class Api(client: IApiClient, parser: IJsonParser): Rest(client, parser) {
        override val type = Type.API_2
    }

    protected suspend fun IApiClient.get() = request(Request.get(path))

    protected suspend fun IApiClient.post() = request(Request.post(path))

    protected suspend fun IApiClient.get(id: Int) = request(Request.get("$path/$id"))

    protected inline fun <reified T : Any> IResponse.deserialize() = parser.deserialize(body, T::class)
}
