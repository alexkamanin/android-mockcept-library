package com.github.alexkamanin.mockcept.domain.repository

import com.github.alexkamanin.mockcept.domain.entity.Account
import com.github.alexkamanin.mockcept.domain.entity.Session

interface AccountRepository {

    suspend fun get(token: String): Account

    suspend fun find(age: Int, type: String): List<Account>

    suspend fun update(token: String, account: Account)

    suspend fun login(token: String): Session

    suspend fun delete(token: String, id: Long)
}