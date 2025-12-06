package com.sargis.khlopuzyan.mobilebanking.auth.screen.about

import com.sargis.khlopuzyan.mobilebanking.core.base.BaseViewModel

class AboutViewModel : BaseViewModel<AboutUIState, AboutUIEvent>() {

    override fun initialUIState() = AboutUIState()

    override fun onEvent(event: AboutUIEvent) {
    }
}