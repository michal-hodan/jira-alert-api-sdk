package com.github.michalhodan.jiraalert

import com.github.michalhodan.jiraalert.endpoint.myself.Myself
import com.github.michalhodan.jiraalert.http.Provider
import com.github.michalhodan.jiraalert.parser.JsonParser
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {

    val client = Provider.httpAuth (
        baseUrl = "dummy.url",
        username = "Dummy",
        password = "password"
    )

    runBlocking {
        Myself(client, JsonParser()).get()
    }
}


