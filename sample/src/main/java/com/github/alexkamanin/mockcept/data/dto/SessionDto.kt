package com.github.alexkamanin.mockcept.data.dto

import com.google.gson.annotations.SerializedName

data class SessionDto(
    @SerializedName("token")
    val accessToken: String,
    val role: String
)