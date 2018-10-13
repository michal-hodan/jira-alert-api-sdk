package com.github.michalhodan.jiraalert.http

import com.github.michalhodan.jiraalert.http.client.ApiClient

class Provider {

    companion object Factory {

        fun basic(credentials: Credentials) = ApiClient.Basic(credentials)

        fun httpAuth(baseUrl: String, username: String, password: String) =
            ApiClient.Basic(Credentials.HttpAuth(baseUrl, username, password))

        fun httpAuth(baseUrl: String, authToken: String) =
            ApiClient.Basic(Credentials.HttpAuth(baseUrl, authToken))
    }
}