package com.github.michalhodan.jiraalert.parser

import kotlin.reflect.KClass
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class JsonParser: IJsonParser {

    private val mapper = jacksonObjectMapper()

    override fun <T : Any> deserialize(data: String, `class`: KClass<T>): T {
        return mapper.readValue(data, `class`.java)
    }
}