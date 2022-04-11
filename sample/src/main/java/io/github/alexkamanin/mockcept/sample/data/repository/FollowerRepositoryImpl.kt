package io.github.alexkamanin.mockcept.sample.data.repository

import io.github.alexkamanin.mockcept.sample.data.api.FollowersApi
import io.github.alexkamanin.mockcept.sample.data.dto.FollowerDto
import io.github.alexkamanin.mockcept.sample.data.mapper.toEntity
import io.github.alexkamanin.mockcept.sample.domain.entity.Follower
import io.github.alexkamanin.mockcept.sample.domain.repository.FollowerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FollowerRepositoryImpl @Inject constructor(
    private val api: FollowersApi
) : FollowerRepository {

    override suspend fun get(userId: Long): List<Follower> =
        withContext(Dispatchers.IO) {
            api.getFollowers(userId).map(FollowerDto::toEntity)
        }

    override suspend fun get(userId: Long, followerId: Long): Follower =
        withContext(Dispatchers.IO) {
            api.getFollower(userId, followerId).toEntity()
        }
}