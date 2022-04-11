package io.github.alexkamanin.mockcept.sample.handler

import io.github.alexkamanin.mockcept.R
import io.github.alexkamanin.mockcept.handler.handlePath
import io.github.alexkamanin.mockcept.response.StatusCode

val followersHandler = handlePath("/user/(1010|1020)/followers") {

    get {
        status = StatusCode.OK
        body = R.raw.get_followers_list_response
    }
    "/9457".get {
        status = StatusCode.OK
        body = R.raw.get_follower_response
    }
    "/4578".get {
        status = StatusCode.BadRequest
    }
}