package com.sargis.khlopuzyan.mobilebanking.auth.screen.registration

import androidx.lifecycle.viewModelScope
import com.sargis.khlopuzyan.mobilebanking.core.base.BaseViewModel
import com.sargis.khlopuzyan.mobilebanking.domain.entity.RegisterUserParam
import com.sargis.khlopuzyan.mobilebanking.domain.entity.User
import com.sargis.khlopuzyan.mobilebanking.domain.usecase.login.RegisterUserUseCase
import com.sargis.khlopuzyan.mobilebanking.domain.util.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class RegistrationViewModel(
    private val registerUserUseCase: RegisterUserUseCase,
) : BaseViewModel<RegistrationUIState, RegistrationUIEvent>() {

    override fun initialUIState() = RegistrationUIState()

    private var _navigationEvent = Channel<RegistrationNavigationEvent>()
    var navigationEvent: Flow<RegistrationNavigationEvent> = _navigationEvent.receiveAsFlow()

    override fun onEvent(uiEvent: RegistrationUIEvent) {
        when (uiEvent) {
            is RegistrationUIEvent.Registration -> register(
                firstName = uiEvent.firstName,
                lastName = uiEvent.lastName,
                username = uiEvent.username,
                password = uiEvent.password
            )
        }
    }

    private fun register(firstName: String, lastName: String, username: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val param = RegisterUserParam(
                firstName = firstName,
                lastName = lastName,
                username = username,
                password = password
            )
            val result = registerUserUseCase(param)

            when (result) {
                is Result.Error<*> -> updateUiState {
                    it.copy(
                        error = result.error
                    )
                }

                is Result.Success<User> -> {
                    result.data?.userId?.let { userId ->
                        updateUiState {
                            it.copy(error = "$username registered successfully")
                        }

                        delay(3000)
                        _navigationEvent.send(RegistrationNavigationEvent.Registered(userId))
                    } ?: run {
                        updateUiState {
                            it.copy(error = "Something went wrong")
                        }
                    }
                }
            }
        }
    }
}