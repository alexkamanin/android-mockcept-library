package com.github.alexkamanin.mockcept.request

import com.github.alexkamanin.mockcept.response.MockceptResponse

internal data class MockceptRequest(
    val method: Method,
    val parameters: List<Regex>,
    val response: MockceptResponse
)

internal fun Array<out Pair<String, Any>>.toQueryStringList(): List<Regex> =
    sortedBy { (name, _) -> name }
        .map { (name, value) -> "$name=$value".toRegex() }