package io.github.alexkamanin.mockcept.sample.data.mapper

import io.github.alexkamanin.mockcept.sample.data.dto.FollowerDto
import io.github.alexkamanin.mockcept.sample.domain.entity.Follower

fun FollowerDto.toEntity() =
    Follower(
        id = id,
        name = name,
        surname = surname
    )