package io.github.alexkamanin.mockcept.sample.domain.usecase

import io.github.alexkamanin.mockcept.sample.domain.entity.Session
import io.github.alexkamanin.mockcept.sample.domain.repository.AccountRepository
import javax.inject.Inject

class LoginAccountUseCase @Inject constructor(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(token: String): Session =
        repository.login(token)
}