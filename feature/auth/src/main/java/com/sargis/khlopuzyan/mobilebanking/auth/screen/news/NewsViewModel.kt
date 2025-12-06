package com.sargis.khlopuzyan.mobilebanking.auth.screen.news

import com.sargis.khlopuzyan.mobilebanking.core.base.BaseViewModel

class NewsViewModel : BaseViewModel<NewsUIState, NewsUIEvent>() {

    override fun initialUIState() = NewsUIState()

    override fun onEvent(event: NewsUIEvent) {
    }
}