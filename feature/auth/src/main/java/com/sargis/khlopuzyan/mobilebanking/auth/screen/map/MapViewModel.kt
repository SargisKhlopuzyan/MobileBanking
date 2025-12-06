package com.sargis.khlopuzyan.mobilebanking.auth.screen.map

import com.sargis.khlopuzyan.mobilebanking.core.base.BaseViewModel

class MapViewModel : BaseViewModel<MapUIState, MapUIEvent>() {

    override fun initialUIState() = MapUIState()

    override fun onEvent(event: MapUIEvent) {
    }
}