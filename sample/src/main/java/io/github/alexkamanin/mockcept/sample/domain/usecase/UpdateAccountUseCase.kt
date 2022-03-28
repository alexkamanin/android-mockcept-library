package io.github.alexkamanin.mockcept.sample.domain.usecase

import io.github.alexkamanin.mockcept.sample.domain.entity.Account
import io.github.alexkamanin.mockcept.sample.domain.repository.AccountRepository
import javax.inject.Inject

class UpdateAccountUseCase @Inject constructor(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(token: String, account: Account) {
        repository.update(token, account)
    }
}