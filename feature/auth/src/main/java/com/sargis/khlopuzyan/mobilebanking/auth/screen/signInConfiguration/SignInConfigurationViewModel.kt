package com.sargis.khlopuzyan.mobilebanking.auth.screen.signInConfiguration

import com.sargis.khlopuzyan.mobilebanking.core.base.BaseViewModel

class SignInConfigurationViewModel :
    BaseViewModel<SignInConfigurationUIState, SignInConfigurationUIEvent>() {

    override fun initialUIState() = SignInConfigurationUIState()

    override fun onEvent(event: SignInConfigurationUIEvent) {
    }
}