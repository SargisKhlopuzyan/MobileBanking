package com.sargis.khlopuzyan.mobilebanking.data.repository

import com.sargis.khlopuzyan.mobilebanking.data.local.source.AppSettingsDataSource
import com.sargis.khlopuzyan.mobilebanking.domain.repository.AppSettingsRepository

class AppSettingsRepositoryImpl(
    private val appSettingsDataSource: AppSettingsDataSource,
) : AppSettingsRepository {

    override fun getAppLocale(): String? {
        return appSettingsDataSource.getAppLocale()
    }

    override fun saveAppLocale(locale: String) {
        appSettingsDataSource.saveAppLocale(locale)
    }
}