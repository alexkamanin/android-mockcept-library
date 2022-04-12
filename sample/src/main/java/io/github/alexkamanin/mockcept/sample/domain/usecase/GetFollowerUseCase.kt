package io.github.alexkamanin.mockcept.sample.domain.usecase

import io.github.alexkamanin.mockcept.sample.domain.entity.Follower
import io.github.alexkamanin.mockcept.sample.domain.repository.FollowerRepository
import javax.inject.Inject

class GetFollowerUseCase @Inject constructor(
    private val repository: FollowerRepository
) {

    suspend operator fun invoke(userId: Long, followerId: Long): Follower =
        repository.get(userId, followerId)
}