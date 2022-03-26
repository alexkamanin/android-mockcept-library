package com.github.alexkamanin.mockcept.handler

import com.github.alexkamanin.mockcept.request.MockceptRequest

abstract class MethodHandler {

    abstract val path: String

    internal val requests: MutableList<MockceptRequest> = mutableListOf()
}