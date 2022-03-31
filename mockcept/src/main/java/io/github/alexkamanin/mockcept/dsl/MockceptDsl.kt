package io.github.alexkamanin.mockcept.dsl

import io.github.alexkamanin.mockcept.handler.PathHandler
import io.github.alexkamanin.mockcept.request.Method
import io.github.alexkamanin.mockcept.request.MockceptRequest
import io.github.alexkamanin.mockcept.request.toQueryStringList
import io.github.alexkamanin.mockcept.response.MockceptResponse

typealias MockceptParameters = Pair<String, Any>

/**
 * Create mocking for GET method
 * @param parameters [Pair]<String, String>, where second value can be regex
 * @param responseBuilder [MockceptResponse]
 *
 * For example:
 * ```
 * get(
 *     "id" to "[0-9]+",
 *     "type" to "subject"
 * ) {
 *     status = StatusCode.OK
 *     body = R.raw.get_sample_response
 * }
 * ```
 */
@MockceptDsl
fun PathHandler.get(
    vararg parameters: MockceptParameters,
    responseBuilder: MockceptResponse.Builder.() -> Unit
) {
    requests.add(
        MockceptRequest(
            Method.GET,
            parameters.toQueryStringList(),
            MockceptResponse.Builder().apply(responseBuilder).build()
        )
    )
}

/**
 * Create mocking for PUT method
 *
 * For example:
 * ```
 * put(
 *     "id" to "[0-9]+",
 *     "type" to "subject"
 * ) {
 *     status = StatusCode.Created
 * }
 * ```
 */
@MockceptDsl
fun PathHandler.put(
    vararg parameters: MockceptParameters,
    responseBuilder: MockceptResponse.Builder.() -> Unit
) {
    requests.add(
        MockceptRequest(
            Method.PUT,
            parameters.toQueryStringList(),
            MockceptResponse.Builder().apply(responseBuilder).build()
        )
    )
}

/**
 * Create mocking for POST method
 *
 * For example:
 * ```
 * post(
 *     "id" to "[0-9]+",
 *     "type" to "subject"
 * ) {
 *     status = StatusCode.NotFound
 *     body = R.raw.not_found_response
 * }
 * ```
 */
@MockceptDsl
fun PathHandler.post(
    vararg parameters: MockceptParameters,
    responseBuilder: MockceptResponse.Builder.() -> Unit
) {
    requests.add(
        MockceptRequest(
            Method.POST,
            parameters.toQueryStringList(),
            MockceptResponse.Builder().apply(responseBuilder).build()
        )
    )
}

/**
 * Create mocking for DELETE method
 *
 * For example:
 * ```
 * delete(
 *     "id" to "[0-9]+",
 *     "type" to "subject"
 * ) {
 *     status = StatusCode.OK
 * }
 * ```
 */
@MockceptDsl
fun PathHandler.delete(
    vararg parameters: MockceptParameters,
    responseBuilder: MockceptResponse.Builder.() -> Unit
) {
    requests.add(
        MockceptRequest(
            Method.DELETE,
            parameters.toQueryStringList(),
            MockceptResponse.Builder().apply(responseBuilder).build()
        )
    )
}