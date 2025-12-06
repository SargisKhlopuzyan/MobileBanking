package com.sargis.khlopuzyan.mibilebanking.main.screen

import com.sargis.khlopuzyan.mobilebanking.core.base.BaseViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

class MainViewModel : BaseViewModel<MainUIState, MainUIEvent>() {

    override fun initialUIState() = MainUIState()

    private var _navigationEvent = Channel<MainNavigationEvent>()
    var navigationEvent: Flow<MainNavigationEvent> = _navigationEvent.receiveAsFlow()

    override fun onEvent(event: MainUIEvent) {

    }
}