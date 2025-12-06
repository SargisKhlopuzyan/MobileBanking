package com.sargis.khlopuzyan.mibilebanking.main.screen

import com.sargis.khlopuzyan.mobilebanking.core.base.UIEvent

sealed interface MainUIEvent : UIEvent {
    object SignedOut : MainUIEvent
    object NavigateUp : MainUIEvent
}