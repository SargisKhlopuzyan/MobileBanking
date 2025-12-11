package com.sargis.khlopuzyan.mobilebanking.auth.screen.login

import com.sargis.khlopuzyan.mobilebanking.core.base.UIEvent

sealed interface LoginUIEvent : UIEvent {
    object NavigateUp : LoginUIEvent
    data class Login(val username: String, val password: String) : LoginUIEvent
    object Register : LoginUIEvent
    object HideDialog : LoginUIEvent
}