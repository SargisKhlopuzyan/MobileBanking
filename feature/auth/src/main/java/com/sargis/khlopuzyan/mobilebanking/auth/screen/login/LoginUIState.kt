package com.sargis.khlopuzyan.mobilebanking.auth.screen.login

import com.sargis.khlopuzyan.mobilebanking.core.base.UIState

data class LoginUIState(
    val lastSignedInUsername: String = "",
    val lastSignedInUserName: String = "Sargis",
    val lastSignedInUserSurname: String = "Khlopuzyan",
    val lastSignedInUserImageUrl: String? = fakeImageUrl,
    val error: String? = null,
) : UIState