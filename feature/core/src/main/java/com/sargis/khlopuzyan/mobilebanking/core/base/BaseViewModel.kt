package com.sargis.khlopuzyan.mobilebanking.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

abstract class BaseViewModel<S : UIState, in E : UIEvent> : ViewModel() {

    protected abstract fun initialUIState(): S

    private var _uiState: MutableStateFlow<S> = MutableStateFlow(initialUIState())
    val uiState: StateFlow<S> = _uiState.onStart {}.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        initialUIState()
    )

    protected fun updateUiState(newState: (S) -> S) {
        _uiState.update(newState)
    }

    abstract fun onEvent(event: E)

}