package com.github.michalhodan.jiraalert.http.client

import java.util.*
import com.github.kittinunf.fuel.core.FuelManager
import com.github.michalhodan.jiraalert.http.Credentials

abstract class ApiClient(credentials: Credentials) {

    init {
        FuelManager.instance.basePath = credentials.url
    }

    class HttpAuth(credentials: Credentials.HttpAuth): ApiClient(credentials) {
        init {
            val authToken = credentials.run { "$username:$password" }.toBase64()
            FuelManager.instance.baseHeaders =  mapOf("Authorization" to "Basic $authToken")
        }
        private fun String.toBase64(): String = Base64.getEncoder().encodeToString(this.toByteArray())
    }


}