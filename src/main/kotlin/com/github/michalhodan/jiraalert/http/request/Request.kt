package com.github.michalhodan.jiraalert.http.request

sealed class Request(val endpoint: String) {

    abstract val method: Method

    class Get(endpoint: String): Request(endpoint) {
        override val method = Method.GET
    }

    class Post(endpoint: String): Request(endpoint) {
        override val method = Method.POST
    }
}