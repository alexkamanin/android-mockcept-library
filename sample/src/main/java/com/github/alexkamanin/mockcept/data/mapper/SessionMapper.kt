package com.github.alexkamanin.mockcept.data.mapper

import com.github.alexkamanin.mockcept.data.dto.SessionDto
import com.github.alexkamanin.mockcept.domain.entity.Session

fun SessionDto.toEntity() = Session(token = accessToken, role = role)