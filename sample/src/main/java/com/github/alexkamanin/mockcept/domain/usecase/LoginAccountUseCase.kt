package com.github.alexkamanin.mockcept.domain.usecase

import com.github.alexkamanin.mockcept.domain.entity.Session
import com.github.alexkamanin.mockcept.domain.repository.AccountRepository
import javax.inject.Inject

class LoginAccountUseCase @Inject constructor(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(token: String): Session =
        repository.login(token)
}