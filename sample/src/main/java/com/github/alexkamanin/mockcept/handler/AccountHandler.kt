package com.github.alexkamanin.mockcept.handler

import com.github.alexkamanin.mockcept.R
import com.github.alexkamanin.mockcept.dsl.delete
import com.github.alexkamanin.mockcept.dsl.get
import com.github.alexkamanin.mockcept.dsl.post
import com.github.alexkamanin.mockcept.dsl.put
import com.github.alexkamanin.mockcept.response.StatusCode

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