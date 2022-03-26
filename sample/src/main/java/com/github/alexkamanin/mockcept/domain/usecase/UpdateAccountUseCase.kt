package com.github.alexkamanin.mockcept.domain.usecase

import com.github.alexkamanin.mockcept.domain.entity.Account
import com.github.alexkamanin.mockcept.domain.repository.AccountRepository
import javax.inject.Inject

class UpdateAccountUseCase @Inject constructor(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(token: String, account: Account) {
        repository.update(token, account)
    }
}