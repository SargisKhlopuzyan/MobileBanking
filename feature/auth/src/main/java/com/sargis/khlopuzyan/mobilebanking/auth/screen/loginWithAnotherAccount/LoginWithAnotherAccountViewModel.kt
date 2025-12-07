package com.sargis.khlopuzyan.mobilebanking.auth.screen.loginWithAnotherAccount

import com.sargis.khlopuzyan.mobilebanking.core.base.BaseViewModel

class LoginWithAnotherAccountViewModel : BaseViewModel<LoginWithAnotherAccountUIState, LoginWithAnotherAccountUIEvent>() {

    override fun initialUIState() = LoginWithAnotherAccountUIState()

    override fun onEvent(event: LoginWithAnotherAccountUIEvent) {
    }
}