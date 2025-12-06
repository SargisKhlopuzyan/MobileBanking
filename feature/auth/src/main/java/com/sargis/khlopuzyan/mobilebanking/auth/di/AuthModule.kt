package com.sargis.khlopuzyan.mobilebanking.auth.di

import com.sargis.khlopuzyan.mobilebanking.auth.screen.about.AboutViewModel
import com.sargis.khlopuzyan.mobilebanking.auth.screen.login.LoginViewModel
import com.sargis.khlopuzyan.mobilebanking.auth.screen.loginMain.LoginMainViewModel
import com.sargis.khlopuzyan.mobilebanking.auth.screen.map.MapViewModel
import com.sargis.khlopuzyan.mobilebanking.auth.screen.news.NewsViewModel
import com.sargis.khlopuzyan.mobilebanking.auth.screen.rates.RatesViewModel
import com.sargis.khlopuzyan.mobilebanking.auth.screen.registration.RegistrationViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

private val viewModelModule = module {
    viewModel {
        LoginMainViewModel(get(), get())
    }

    viewModel {
        RatesViewModel()
    }

    viewModel {
        MapViewModel()
    }

    viewModel {
        NewsViewModel()
    }

    viewModel {
        AboutViewModel()
    }

    viewModel {
        LoginViewModel(get(), get())
    }

    viewModel {
        RegistrationViewModel(get())
    }
}

val authModule = listOf(viewModelModule)