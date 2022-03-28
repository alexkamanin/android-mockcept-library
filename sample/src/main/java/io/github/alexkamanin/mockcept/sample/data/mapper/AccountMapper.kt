package io.github.alexkamanin.mockcept.sample.data.mapper

import io.github.alexkamanin.mockcept.sample.data.dto.AccountDto
import io.github.alexkamanin.mockcept.sample.domain.entity.Account

fun AccountDto.toEntity() = Account(name = name, surname = surname, age = age)

fun Account.toDto() = AccountDto(name = name, surname = surname, age = age)