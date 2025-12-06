package com.sargis.khlopuzyan.mobilebanking.auth.screen.rates

import com.sargis.khlopuzyan.mobilebanking.core.base.BaseViewModel

class RatesViewModel : BaseViewModel<RatesUIState, RatesUIEvent>() {

    override fun initialUIState() = RatesUIState()

    override fun onEvent(event: RatesUIEvent) {
    }
}