package com.sargis.khlopuzyan.mobilebanking.auth.screen.registration

sealed interface RegistrationNavigationEvent {
    object NavigateUp : RegistrationNavigationEvent
    data class Registered(val userId: Int) : RegistrationNavigationEvent
}