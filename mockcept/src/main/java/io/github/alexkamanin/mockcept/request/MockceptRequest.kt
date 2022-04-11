package io.github.alexkamanin.mockcept.request

import io.github.alexkamanin.mockcept.response.MockceptResponse

internal data class MockceptRequest(
    val path: Regex,
    val method: Method,
    val queries: List<Regex>,
    val response: MockceptResponse
)