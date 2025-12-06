package com.sargis.khlopuzyan.mobilebanking.data.di

import com.sargis.khlopuzyan.mobilebanking.data.local.dao.UserDao
import com.sargis.khlopuzyan.mobilebanking.data.local.db.UserDatabase
import com.sargis.khlopuzyan.mobilebanking.data.local.sharedPreferences.AppSettingsSharedPref
import com.sargis.khlopuzyan.mobilebanking.data.local.source.AppSettingsDataSource
import com.sargis.khlopuzyan.mobilebanking.data.local.source.AppSettingsDataSourceImpl
import com.sargis.khlopuzyan.mobilebanking.data.local.source.UserDataSource
import com.sargis.khlopuzyan.mobilebanking.data.local.source.UserDataSourceImpl
import com.sargis.khlopuzyan.mobilebanking.data.repository.AppSettingsRepositoryImpl
import com.sargis.khlopuzyan.mobilebanking.data.repository.UserRepositoryImpl
import com.sargis.khlopuzyan.mobilebanking.domain.repository.AppSettingsRepository
import com.sargis.khlopuzyan.mobilebanking.domain.repository.UserRepository
import org.koin.dsl.module

private val repositoryModule = module {
    single<UserRepository> {
        UserRepositoryImpl(get())
    }
    single<AppSettingsRepository> {
        AppSettingsRepositoryImpl(get())
    }
}

private val sharedPrefModule = module {
    single<AppSettingsSharedPref> {
        AppSettingsSharedPref(get())
    }
}

private val databaseModule = module {
    single<UserDatabase> {
        UserDatabase.getInstance(get())
    }
    single<UserDao> {
        get<UserDatabase>().userDao()
    }
    single<UserDataSource> {
        UserDataSourceImpl(get(), get())
    }
    single<AppSettingsDataSource> {
        AppSettingsDataSourceImpl(get())
    }
}

val dataModule = listOf(sharedPrefModule, databaseModule, repositoryModule)
