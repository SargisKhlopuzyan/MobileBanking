package com.sargis.khlopuzyan.mobilebanking.auth.screen.login

import com.sargis.khlopuzyan.mobilebanking.core.base.UIState

data class LoginUIState(
    val lastSignedInUsername: String? = null,
    val error: String? = null,
) : UIState