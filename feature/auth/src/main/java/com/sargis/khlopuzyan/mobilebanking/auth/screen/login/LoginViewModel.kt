package com.sargis.khlopuzyan.mobilebanking.auth.screen.login

import androidx.lifecycle.viewModelScope
import com.sargis.khlopuzyan.mobilebanking.core.base.BaseViewModel
import com.sargis.khlopuzyan.mobilebanking.domain.entity.LoginUserParam
import com.sargis.khlopuzyan.mobilebanking.domain.entity.User
import com.sargis.khlopuzyan.mobilebanking.domain.usecase.login.GetLastSignedInUsernameUseCase
import com.sargis.khlopuzyan.mobilebanking.domain.usecase.login.LoginUserUseCase
import com.sargis.khlopuzyan.mobilebanking.domain.util.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val getLastSignedInUsernameUseCase: GetLastSignedInUsernameUseCase,
    private val loginUserUseCase: LoginUserUseCase,
) : BaseViewModel<LoginUIState, LoginUIEvent>() {

    override fun initialUIState() = LoginUIState()

    private var _navigationEvent = Channel<LoginNavigationEvent>()
    var navigationEvent: Flow<LoginNavigationEvent> = _navigationEvent.receiveAsFlow()

    override fun onEvent(uiEvent: LoginUIEvent) {
        when (uiEvent) {
            is LoginUIEvent.Login -> login(uiEvent.username, uiEvent.password)
            LoginUIEvent.HideDialog -> updateUiState {
                it.copy(
                    error = null
                )
            }
            LoginUIEvent.NavigateUp -> TODO()
            LoginUIEvent.Register -> TODO()
        }
    }

    private fun login(username: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val param = LoginUserParam(
                username = username,
                password = password
            )
            val result = loginUserUseCase(param)
            when (result) {
                is Result.Error<*> -> updateUiState {
                    it.copy(
                        error = result.error
                    )
                }

                is Result.Success<User> -> {
                    result.data?.userId?.let { userId ->
                        viewModelScope.launch {
                            _navigationEvent.send(LoginNavigationEvent.AuthSuccess(userId))
                        }
                    } ?: run {
                        updateUiState {
                            it.copy(error = "Something went wrong")
                        }
                    }
                }
            }
        }
    }

    private fun fetchLastSignedInUser() {
        val username = getLastSignedInUsernameUseCase()
        username?.let {
            updateUiState {
                it.copy(
                    lastSignedInUsername = username
                )
            }
        }
    }
}