package io.github.alexkamanin.mockcept.sample.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.alexkamanin.mockcept.sample.domain.entity.Account
import io.github.alexkamanin.mockcept.sample.domain.usecase.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val loginAccountUseCase: LoginAccountUseCase,
    private val updateAccountUseCase: UpdateAccountUseCase,
    private val deleteAccountUseCase: DeleteAccountUseCase,
    private val getAccountUseCase: GetAccountUseCase,
    private val findAccountUseCase: FindAccountUseCase,
    private val getFollowersUseCase: GetFollowersUseCase
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

            getFollowersUseCase(userId = 1010)
            getFollowersUseCase(userId = 1020)

            // ------ Not mocked example ------
            runCatching {
                getFollowersUseCase(userId = 1030)
            }
        }
    }
}