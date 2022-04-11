package io.github.alexkamanin.mockcept.sample.data.api

import io.github.alexkamanin.mockcept.sample.data.dto.FollowerDto
import retrofit2.http.GET
import retrofit2.http.Path

interface FollowersApi {

    @GET("/user/{userId}/followers")
    suspend fun getFollowers(@Path("userId") userId: Long): List<FollowerDto>

    @GET("/user/{userId}/followers/{followerId}")
    suspend fun getFollower(
        @Path("userId") userId: Long,
        @Path("followerId") followerId: Long
    ): FollowerDto
}