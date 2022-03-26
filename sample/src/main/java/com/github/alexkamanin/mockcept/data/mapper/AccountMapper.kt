package com.github.alexkamanin.mockcept.data.mapper

import com.github.alexkamanin.mockcept.data.dto.AccountDto
import com.github.alexkamanin.mockcept.domain.entity.Account

fun AccountDto.toEntity() = Account(name = name, surname = surname, age = age)

fun Account.toDto() = AccountDto(name = name, surname = surname, age = age)