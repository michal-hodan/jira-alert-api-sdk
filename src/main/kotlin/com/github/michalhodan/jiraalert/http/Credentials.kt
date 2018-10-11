package com.github.michalhodan.jiraalert.http

sealed class Credentials(val url: String) {

    class HttpAuth(url: String, val username:  String, val password: String): Credentials(url)
}