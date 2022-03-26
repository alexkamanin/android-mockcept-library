package com.github.alexkamanin.mockcept.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.alexkamanin.mockcept.domain.entity.Account
import com.github.alexkamanin.mockcept.domain.usecase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val loginAccountUseCase: LoginAccountUseCase,
    private val updateAccountUseCase: UpdateAccountUseCase,
    private val deleteAccountUseCase: DeleteAccountUseCase,
    private val getAccountUseCase: GetAccountUseCase,
    private val findAccountUseCase: FindAccountUseCase,
) : ViewModel() {

    // ------ See logcat ------
    fun test() {
        viewModelScope.launch {
            val session = loginAccountUseCase(token = "YWRtaW5AcXdlcnR5LmNvbToxMmFiMzRjZDU2Nw==")

            getAccountUseCase(token = session.token)

            updateAccountUseCase(
                token = session.token,
                account = Account(name = "Alex", surname = "Kamanin", age = 22)
            )

            deleteAccountUseCase(token = session.token, id = 100001)
            deleteAccountUseCase(token = session.token, id = 100874)

            findAccountUseCase(23, "student")

            // ------ Not mocked example ------
            runCatching {
                findAccountUseCase(41, "teacher")
            }
        }
    }
}