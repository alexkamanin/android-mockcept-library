package io.github.alexkamanin.mockcept.handler

import io.github.alexkamanin.mockcept.dsl.MockceptDsl
import io.github.alexkamanin.mockcept.request.Method
import io.github.alexkamanin.mockcept.request.MockceptRequest
import io.github.alexkamanin.mockcept.response.MockceptResponse

/**
 * Create [PathHandler] for [Mockcept]
 * @param path [String] Base path, which mocked
 * @param builder [PathHandler.Builder] Builder for GET, POST, PUT and DELETE methods
 *
 * For example:
 * ```
 * val sampleHandler = handlePath("/sample") {
 *
 *     get {
 *         status = StatusCode.OK
 *         body = R.raw.response
 *     }
 *     post {
 *         status = StatusCode.OK
 *         body = R.raw.response
 *     }
 * }
 * ```
 */
fun handlePath(path: String, builder: PathHandler.Builder.() -> Unit): PathHandler =
    PathHandler.Builder(path).apply(builder).build()

class PathHandler private constructor(
    internal val requests: List<MockceptRequest>
) {
    @MockceptDsl
    class Builder(private val path: String) {

        private val requests: MutableList<MockceptRequest> = mutableListOf()

        internal fun build(): PathHandler =
            PathHandler(requests)

        /**
         * Add expression to the end of the path, which may be [Regex]
         * and create mocking for GET method
         * @param queries [Pair]<[String], [Any]>, where second value may be [Regex]
         * @param response [MockceptResponse]
         *
         * For example:
         * ```
         * "[0-9]+".get(
         *     "id" to "[0-9]+",
         *     "type" to "subject"
         * ) {
         *     status = StatusCode.OK
         *     body = R.raw.get_sample_response
         * }
         * ```
         */
        fun String.get(
            vararg queries: Pair<String, Any>,
            response: MockceptResponse.Builder.() -> Unit
        ) {
            MockceptRequest(
                path = (path + this).toRegex(),
                method = Method.GET,
                queries = queries.values(),
                response = MockceptResponse.Builder().apply(response).build()
            ).also(requests::add)
        }

        /**
         * Add expression to the end of the path, which may be [Regex]
         * and create mocking for POST method
         * @param queries [Pair]<[String], [Any]>, where second value may be [Regex]
         * @param response [MockceptResponse]
         *
         * For example:
         * ```
         * "[0-9]+".post(
         *     "id" to "[0-9]+",
         *     "type" to "subject"
         * ) {
         *     status = StatusCode.OK
         * }
         * ```
         */
        fun String.post(
            vararg queries: Pair<String, Any>,
            response: MockceptResponse.Builder.() -> Unit
        ) {
            MockceptRequest(
                path = (path + this).toRegex(),
                method = Method.POST,
                queries = queries.values(),
                response = MockceptResponse.Builder().apply(response).build()
            ).also(requests::add)
        }

        /**
         * Add expression to the end of the path, which may be [Regex]
         * and create mocking for PUT method
         * @param queries [Pair]<[String], [Any]>, where second value may be [Regex]
         * @param response [MockceptResponse]
         *
         * For example:
         * ```
         * "[0-9]+".put(
         *     "id" to "[0-9]+",
         *     "type" to "subject"
         * ) {
         *     status = StatusCode.Created
         * }
         * ```
         */
        fun String.put(
            vararg queries: Pair<String, Any>,
            response: MockceptResponse.Builder.() -> Unit
        ) {
            MockceptRequest(
                path = (path + this).toRegex(),
                method = Method.PUT,
                queries = queries.values(),
                response = MockceptResponse.Builder().apply(response).build()
            ).also(requests::add)
        }

        /**
         * Add expression to the end of the path, which may be [Regex]
         * and create mocking for DELETE method
         * @param queries [Pair]<[String], [Any]>, where second value may be [Regex]
         * @param response [MockceptResponse]
         *
         * For example:
         * ```
         * "[0-9]+".delete(
         *     "id" to "[0-9]+",
         *     "type" to "subject"
         * ) {
         *     status = StatusCode.OK
         * }
         * ```
         */
        fun String.delete(
            vararg queries: Pair<String, Any>,
            response: MockceptResponse.Builder.() -> Unit
        ) {
            MockceptRequest(
                path = (path + this).toRegex(),
                method = Method.DELETE,
                queries = queries.values(),
                response = MockceptResponse.Builder().apply(response).build()
            ).also(requests::add)
        }

        /**
         * Create mocking for GET method
         * @param queries [Pair]<[String], [Any]>, where second value may be [Regex]
         * @param response [MockceptResponse]
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
        fun get(
            vararg queries: Pair<String, Any>,
            response: MockceptResponse.Builder.() -> Unit
        ) {
            MockceptRequest(
                path = path.toRegex(),
                method = Method.GET,
                queries = queries.values(),
                response = MockceptResponse.Builder().apply(response).build()
            ).also(requests::add)
        }

        /**
         * Create mocking for POST method
         * @param queries [Pair]<[String], [Any]>, where second value may be [Regex]
         * @param response [MockceptResponse]
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
        fun post(
            vararg queries: Pair<String, Any>,
            response: MockceptResponse.Builder.() -> Unit
        ) {
            MockceptRequest(
                path = path.toRegex(),
                method = Method.POST,
                queries = queries.values(),
                response = MockceptResponse.Builder().apply(response).build()
            ).also(requests::add)
        }

        /**
         * Create mocking for PUT method
         * @param queries [Pair]<[String], [Any]>, where second value may be [Regex]
         * @param response [MockceptResponse]
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
        fun put(
            vararg queries: Pair<String, Any>,
            response: MockceptResponse.Builder.() -> Unit
        ) {
            MockceptRequest(
                path = path.toRegex(),
                method = Method.PUT,
                queries = queries.values(),
                response = MockceptResponse.Builder().apply(response).build()
            ).also(requests::add)
        }

        /**
         * Create mocking for DELETE method
         * @param queries [Pair]<[String], [Any]>, where second value may be [Regex]
         * @param response [MockceptResponse]
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
        fun delete(
            vararg queries: Pair<String, Any>,
            response: MockceptResponse.Builder.() -> Unit
        ) {
            MockceptRequest(
                path = path.toRegex(),
                method = Method.DELETE,
                queries = queries.values(),
                response = MockceptResponse.Builder().apply(response).build()
            ).also(requests::add)
        }

        private fun Array<out Pair<String, Any>>.values(): List<Regex> =
            sortedBy { (name, _) -> name }
                .map { (name, value) -> "$name=$value".toRegex() }
    }
}