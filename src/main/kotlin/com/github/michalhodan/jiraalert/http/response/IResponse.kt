package com.github.michalhodan.jiraalert.http.response

import java.io.InputStream

interface IResponse {

    val statusCode: StatusCode

    val headers: Map<String, List<String>>

    val body: InputStream
}