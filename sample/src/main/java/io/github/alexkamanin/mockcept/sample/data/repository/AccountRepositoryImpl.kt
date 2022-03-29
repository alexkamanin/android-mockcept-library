package io.github.alexkamanin.mockcept.sample.data.repository

import io.github.alexkamanin.mockcept.sample.data.api.AccountApi
import io.github.alexkamanin.mockcept.sample.data.dto.AccountDto
import io.github.alexkamanin.mockcept.sample.data.mapper.toDto
import io.github.alexkamanin.mockcept.sample.data.mapper.toEntity
import io.github.alexkamanin.mockcept.sample.domain.entity.Account
import io.github.alexkamanin.mockcept.sample.domain.entity.Session
import io.github.alexkamanin.mockcept.sample.domain.repository.AccountRepository
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