package com.github.alexkamanin.mockcept.data.repository

import com.github.alexkamanin.mockcept.data.api.AccountApi
import com.github.alexkamanin.mockcept.data.dto.AccountDto
import com.github.alexkamanin.mockcept.data.mapper.toDto
import com.github.alexkamanin.mockcept.data.mapper.toEntity
import com.github.alexkamanin.mockcept.domain.entity.Account
import com.github.alexkamanin.mockcept.domain.entity.Session
import com.github.alexkamanin.mockcept.domain.repository.AccountRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(
    private val api: AccountApi
) : AccountRepository {

    override suspend fun get(token: String): Account =
        withContext(Dispatchers.IO) {
            api.get(token).toEntity()
        }

    override suspend fun find(age: Int, type: String): List<Account> =
        withContext(Dispatchers.IO) {
            api.find(age, type).map(AccountDto::toEntity)
        }

    override suspend fun update(token: String, account: Account) {
        withContext(Dispatchers.IO) {
            api.update(token, account.toDto())
        }
    }

    override suspend fun login(token: String): Session =
        withContext(Dispatchers.IO) {
            api.login(token).toEntity()
        }

    override suspend fun delete(token: String, id: Long) {
        withContext(Dispatchers.IO) {
            api.delete(token, id)
        }
    }
}