package com.sargis.khlopuzyan.mobilebanking.domain.repository

interface AppSettingsRepository {
    fun getAppLocale(): String?
    fun saveAppLocale(locale: String)
}