package com.github.michalhodan.jiraalert.http.response

class Response(
    override val statusCode: StatusCode,
    override val headers: Map<String, List<String>>,
    override val body: String
): IResponse