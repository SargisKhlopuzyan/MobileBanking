package com.sargis.khlopuzyan.mobilebanking

import android.app.Application
import com.sargis.khlopuzyan.mibilebanking.main.di.mainModule
import com.sargis.khlopuzyan.mobilebanking.auth.di.authModule
import com.sargis.khlopuzyan.mobilebanking.data.di.dataModule
import com.sargis.khlopuzyan.mobilebanking.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class MobileBankingApp : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MobileBankingApp)
            modules(dataModule + domainModule + authModule + mainModule)
        }
    }
}