package com.sargis.khlopuzyan.mibilebanking.main.di

import com.sargis.khlopuzyan.mibilebanking.main.screen.MainViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

private val viewModelModule = module {
    viewModel<MainViewModel> {
        MainViewModel()
    }
}

val mainModule = listOf(viewModelModule)