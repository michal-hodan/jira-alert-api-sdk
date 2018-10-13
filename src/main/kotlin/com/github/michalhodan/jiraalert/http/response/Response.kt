package com.github.michalhodan.jiraalert.http.response

import java.io.InputStream

class Response(
    override val statusCode: StatusCode,
    override val headers: Map<String, List<String>>,
    override val body: InputStream
): IResponse