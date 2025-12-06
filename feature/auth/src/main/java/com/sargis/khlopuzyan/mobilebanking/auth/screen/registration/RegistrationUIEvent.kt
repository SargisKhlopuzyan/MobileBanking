package com.sargis.khlopuzyan.mobilebanking.auth.screen.registration

import com.sargis.khlopuzyan.mobilebanking.core.base.UIEvent

sealed interface RegistrationUIEvent : UIEvent {
    data class Registration(
        val firstName: String,
        val lastName: String,
        val username: String,
        val password: String,
    ) : RegistrationUIEvent
}