package io.github.alexkamanin.mockcept.sample.handler

import io.github.alexkamanin.mockcept.sample.R
import io.github.alexkamanin.mockcept.handler.handlePath
import io.github.alexkamanin.mockcept.response.StatusCode

val accountHandler = handlePath("/user/account") {

    get {
        status = StatusCode.OK
        body = R.raw.get_account_response_1
    }
    get {
        status = StatusCode.OK
        body = R.raw.get_account_response_2
    }
    get(
        "age" to "[0-9]+",
        "type" to "student"
    ) {
        status = StatusCode.OK
        body = R.raw.get_account_list_response
    }
    put {
        status = StatusCode.Created
    }
    post {
        status = StatusCode.OK
        body = R.raw.post_account_response
    }
    delete(
        "id" to "[0-9]+".toRegex()
    ) {
        status = StatusCode.OK
    }
}