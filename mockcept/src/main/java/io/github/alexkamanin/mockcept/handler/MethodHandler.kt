package io.github.alexkamanin.mockcept.handler

import io.github.alexkamanin.mockcept.request.MockceptRequest

abstract class MethodHandler {

    abstract val path: String

    internal val requests: MutableList<MockceptRequest> = mutableListOf()
}