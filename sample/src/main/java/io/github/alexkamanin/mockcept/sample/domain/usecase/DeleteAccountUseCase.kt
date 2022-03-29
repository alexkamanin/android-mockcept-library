package io.github.alexkamanin.mockcept.sample.domain.usecase

import io.github.alexkamanin.mockcept.sample.domain.repository.AccountRepository
import javax.inject.Inject

class DeleteAccountUseCase @Inject constructor(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(token: String, id: Long) {
        repository.delete(token, id)
    }
}