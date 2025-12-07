package com.sargis.khlopuzyan.mobilebanking.auth.screen.loginWithAnotherAccount

import com.sargis.khlopuzyan.mobilebanking.core.base.UIEvent

sealed interface LoginWithAnotherAccountUIEvent : UIEvent {
    object ResetPassword : LoginWithAnotherAccountUIEvent
    data class Login(val username: String, val password: String) : LoginWithAnotherAccountUIEvent
}