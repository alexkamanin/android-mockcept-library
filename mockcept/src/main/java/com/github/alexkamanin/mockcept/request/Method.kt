@file:Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package com.github.alexkamanin.mockcept.request

internal enum class Method {
    GET,
    PUT,
    POST,
    DELETE
}

internal inline fun <reified T : Enum<*>> enumValueOrNull(name: String): T? =
    T::class.java.enumConstants.firstOrNull { it.name == name }