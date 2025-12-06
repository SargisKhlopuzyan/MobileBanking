package com.sargis.khlopuzyan.mobilebanking.data.local.source

import com.sargis.khlopuzyan.mobilebanking.data.local.sharedPreferences.AppSettingsSharedPref

interface AppSettingsDataSource {
    fun getAppLocale(): String?
    fun saveAppLocale(locale: String)
}

class AppSettingsDataSourceImpl(
    val appSettingsSharedPref: AppSettingsSharedPref,
) : AppSettingsDataSource {
    override fun getAppLocale(): String? {
        return appSettingsSharedPref.getAppLocale()
    }

    override fun saveAppLocale(locale: String) {
        appSettingsSharedPref.saveAppLocale(locale)
    }
}