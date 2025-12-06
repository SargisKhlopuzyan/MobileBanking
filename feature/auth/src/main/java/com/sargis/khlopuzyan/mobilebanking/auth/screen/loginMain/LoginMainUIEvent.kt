package com.sargis.khlopuzyan.mobilebanking.auth.screen.loginMain

import com.sargis.khlopuzyan.mobilebanking.core.base.UIEvent

sealed interface LoginMainUIEvent : UIEvent {
    data class ChangeLocale(val locale: String) : LoginMainUIEvent
    object ChooseLocale : LoginMainUIEvent
    object Login : LoginMainUIEvent
    object OnlineRegistration : LoginMainUIEvent
    object Rates : LoginMainUIEvent
    object Maps : LoginMainUIEvent
    object News : LoginMainUIEvent
    object About : LoginMainUIEvent
}