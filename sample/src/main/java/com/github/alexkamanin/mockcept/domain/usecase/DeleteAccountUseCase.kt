package com.github.alexkamanin.mockcept.domain.usecase

import com.github.alexkamanin.mockcept.domain.repository.AccountRepository
import javax.inject.Inject

class DeleteAccountUseCase @Inject constructor(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(token: String, id: Long) {
        repository.delete(token, id)
    }
}