package com.sargis.khlopuzyan.mobilebanking.data.local.sharedPreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class AppSettingsSharedPref(val context: Context) {

    private val sharedPref: SharedPreferences by lazy {
        context.getSharedPreferences("AppSettingsPrefs", Context.MODE_PRIVATE)
    }

    fun saveAppLocale(locale: String) {
        sharedPref.edit {
            putString("locale", locale)
        }
    }

    fun getAppLocale(): String? {
        return sharedPref.getString("locale", null)
    }

    fun saveLastSignedInUsername(username: String) {
        sharedPref.edit {
            putString("username", username)
        }
    }

    fun getLastSignedInUsername(): String? {
        return sharedPref.getString("username", null)
    }
}