package io.github.alexkamanin.mockcept.sample.domain.repository

import io.github.alexkamanin.mockcept.sample.domain.entity.Follower

interface FollowerRepository {

    suspend fun get(userId: Long): List<Follower>

    suspend fun get(userId: Long, followerId: Long): Follower
}