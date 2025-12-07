package com.sargis.khlopuzyan.mobilebanking.auth.screen.resetPassword

import com.sargis.khlopuzyan.mobilebanking.core.base.BaseViewModel

class ResetPasswordViewModel : BaseViewModel<ResetPasswordUIState, ResetPasswordUIEvent>() {

    override fun initialUIState() = ResetPasswordUIState()

    override fun onEvent(event: ResetPasswordUIEvent) {
    }
}