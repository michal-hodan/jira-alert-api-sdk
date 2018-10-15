package com.github.michalhodan.jiraalert.parser

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import kotlin.reflect.KClass
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class JsonParser private constructor(private val mapper: ObjectMapper): IJsonParser {

    companion object {
        private val instance = jacksonObjectMapper()

        init {
            instance.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        }

        fun make() = JsonParser(instance)
    }

    override fun <T : Any> deserialize(data: String, `class`: KClass<T>): T {
        return mapper.readValue(data, `class`.java)
    }
}