package com.sargis.khlopuzyan.mobilebanking.auth.screen.loginMain

import com.sargis.khlopuzyan.mobilebanking.core.base.BaseViewModel
import com.sargis.khlopuzyan.mobilebanking.domain.usecase.app.GetAppLocaleUseCase
import com.sargis.khlopuzyan.mobilebanking.domain.usecase.app.SetAppLocaleUseCase
import com.sargis.khlopuzyan.mobilebanking.domain.usecase.login.GetLastSignedInUsernameUseCase

class LoginMainViewModel(
    private val getAppLocaleUseCase: GetAppLocaleUseCase,
    private val setAppLocaleUseCase: SetAppLocaleUseCase,
    private val lastSignedInUsernameUseCase: GetLastSignedInUsernameUseCase,
) : BaseViewModel<LoginMainUIState, LoginMainUIEvent>() {

    override fun initialUIState() = LoginMainUIState()

//    private var _navigationEvent = Channel<LoginMainNavigationEvent>()
//    var navigationEvent: Flow<LoginMainNavigationEvent> = _navigationEvent.receiveAsFlow()

    override fun onEvent(uiEvent: LoginMainUIEvent) {
        when (uiEvent) {
            is LoginMainUIEvent.ChangeLocale -> changeLocale(uiEvent.locale)
            else -> {}
        }
    }

    private fun changeLocale(locale: String) {
        setAppLocaleUseCase(locale)
    }

    private fun fetchLastSignedInUser() {
        val locale = getAppLocaleUseCase()
        updateUiState {
            it.copy(
                locale = locale
            )
        }
    }
}