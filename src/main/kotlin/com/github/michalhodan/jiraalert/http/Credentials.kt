package com.github.michalhodan.jiraalert.http

import java.util.*

sealed class Credentials(val url: String, val authToken: String) {

    class HttpAuth constructor(url: String, authToken: String): Credentials(url, authToken) {

        constructor(url: String,  username: String, password: String): this(url, "$username:$password".toBase64())

        private companion object {
            fun String.toBase64(): String = Base64.getEncoder().encodeToString(this.toByteArray())
        }
    }
}