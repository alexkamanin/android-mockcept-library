package io.github.alexkamanin.mockcept.sample.handler

import io.github.alexkamanin.mockcept.R
import io.github.alexkamanin.mockcept.dsl.get
import io.github.alexkamanin.mockcept.handler.PathHandler
import io.github.alexkamanin.mockcept.response.StatusCode

object FollowersHandler : PathHandler() {

    override val path = "/user/(1010|1020)/followers"

    init {
        get {
            status = StatusCode.OK
            body = R.raw.get_followers_list_response
        }
    }
}