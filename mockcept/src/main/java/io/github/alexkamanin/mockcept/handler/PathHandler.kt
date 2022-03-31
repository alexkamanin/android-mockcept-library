package io.github.alexkamanin.mockcept.handler

import io.github.alexkamanin.mockcept.request.MockceptRequest

/**
 * Description for method mocking
 *
 * @property path Path mapping, for example, **"/sample/something"**
 * @property requests A list with a description of all the mocking [GET], [POST], [PUT], [DELETE] methods available by path
 */
abstract class PathHandler {

    abstract val path: String

    internal val requests: MutableList<MockceptRequest> = mutableListOf()
}