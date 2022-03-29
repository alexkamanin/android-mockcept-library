package io.github.alexkamanin.mockcept.sample.data.mapper

import io.github.alexkamanin.mockcept.sample.data.dto.SessionDto
import io.github.alexkamanin.mockcept.sample.domain.entity.Session

fun SessionDto.toEntity() = Session(token = accessToken, role = role)