package io.github.alexkamanin.mockcept.dsl

import io.github.alexkamanin.mockcept.handler.MethodHandler
import io.github.alexkamanin.mockcept.request.Method
import io.github.alexkamanin.mockcept.request.MockceptRequest
import io.github.alexkamanin.mockcept.request.toQueryStringList
import io.github.alexkamanin.mockcept.response.MockceptResponse

typealias MockceptResponseBuilder = MockceptResponse.() -> Unit
typealias MockceptParameters = Pair<String, Any>

@MockceptDsl
fun MethodHandler.get(vararg parameters: MockceptParameters, response: MockceptResponseBuilder) {
    requests.add(
        MockceptRequest(
            Method.GET,
            parameters.toQueryStringList(),
            MockceptResponse().apply(response)
        )
    )
}

@MockceptDsl
fun MethodHandler.put(vararg parameters: MockceptParameters, response: MockceptResponseBuilder) {
    requests.add(
        MockceptRequest(
            Method.PUT,
            parameters.toQueryStringList(),
            MockceptResponse().apply(response)
        )
    )
}

@MockceptDsl
fun MethodHandler.post(vararg parameters: MockceptParameters, response: MockceptResponseBuilder) {
    requests.add(
        MockceptRequest(
            Method.POST,
            parameters.toQueryStringList(),
            MockceptResponse().apply(response)
        )
    )
}

@MockceptDsl
fun MethodHandler.delete(vararg parameters: MockceptParameters, response: MockceptResponseBuilder) {
    requests.add(
        MockceptRequest(
            Method.DELETE,
            parameters.toQueryStringList(),
            MockceptResponse().apply(response)
        )
    )
}