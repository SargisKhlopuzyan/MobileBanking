package com.sargis.khlopuzyan.mobilebanking.auth.screen.login

sealed interface LoginNavigationEvent {
    object NavigateUp : LoginNavigationEvent
    data class AuthSuccess(val userId: Int) : LoginNavigationEvent
}