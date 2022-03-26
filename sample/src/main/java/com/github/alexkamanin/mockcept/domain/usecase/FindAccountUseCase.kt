package com.github.alexkamanin.mockcept.domain.usecase

import com.github.alexkamanin.mockcept.domain.entity.Account
import com.github.alexkamanin.mockcept.domain.repository.AccountRepository
import javax.inject.Inject

class FindAccountUseCase @Inject constructor(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(age: Int, type: String): List<Account> =
        repository.find(age, type)
}