package com.github.michalhodan.jiraalert.parser

import kotlin.reflect.KClass

interface IJsonParser {
    fun <T: Any>deserialize(data: String, `class`: KClass<T>): T
}