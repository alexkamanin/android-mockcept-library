package io.github.alexkamanin.mockcept.sample.domain.usecase

import io.github.alexkamanin.mockcept.sample.domain.entity.Account
import io.github.alexkamanin.mockcept.sample.domain.repository.AccountRepository
import javax.inject.Inject

class FindAccountUseCase @Inject constructor(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(age: Int, type: String): List<Account> =
        repository.find(age, type)
}