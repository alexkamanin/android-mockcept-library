package io.github.alexkamanin.mockcept.sample.domain.repository

import io.github.alexkamanin.mockcept.sample.domain.entity.Account
import io.github.alexkamanin.mockcept.sample.domain.entity.Session

interface AccountRepository {

    suspend fun get(token: String): Account

    suspend fun find(age: Int, type: String): List<Account>

    suspend fun update(token: String, account: Account)

    suspend fun login(token: String): Session

    suspend fun delete(token: String, id: Long)
}