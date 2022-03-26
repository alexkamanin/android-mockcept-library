package com.github.alexkamanin.mockcept.data.api

import com.github.alexkamanin.mockcept.data.dto.AccountDto
import com.github.alexkamanin.mockcept.data.dto.SessionDto
import retrofit2.http.*

interface AccountApi {

    @GET("/user/account")
    suspend fun get(@Header("X-Access-Token") token: String): AccountDto

    @GET("/user/account")
    suspend fun find(
        @Query("age") age: Int,
        @Query("type") type: String
    ): List<AccountDto>

    @PUT("/user/account")
    suspend fun update(
        @Header("X-Access-Token") token: String,
        @Body account: AccountDto
    )

    @POST("/user/account")
    suspend fun login(@Header("X-Authentication") token: String): SessionDto

    @DELETE("/user/account")
    suspend fun delete(
        @Header("X-Access-Token") token: String,
        @Query("id") id: Long
    )
}