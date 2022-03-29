package io.github.alexkamanin.mockcept.sample.handler

import io.github.alexkamanin.mockcept.R
import io.github.alexkamanin.mockcept.dsl.delete
import io.github.alexkamanin.mockcept.dsl.get
import io.github.alexkamanin.mockcept.dsl.post
import io.github.alexkamanin.mockcept.dsl.put
import io.github.alexkamanin.mockcept.handler.MethodHandler
import io.github.alexkamanin.mockcept.response.StatusCode

object AccountHandler : MethodHandler() {

    override val path = "/user/account"

    init {
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
}