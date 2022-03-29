package io.github.alexkamanin.mockcept.response

import androidx.annotation.RawRes

data class MockceptResponse(
    var status: StatusCode = StatusCode.OK,
    @RawRes var body: Int? = null
)