package com.github.michalhodan.jiraalert.http.response

interface IResponse {

    val statusCode: StatusCode

    val headers: Map<String, List<String>>

    val body: String
}