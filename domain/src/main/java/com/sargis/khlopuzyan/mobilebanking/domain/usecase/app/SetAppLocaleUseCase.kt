package com.sargis.khlopuzyan.mobilebanking.domain.usecase.app

import com.sargis.khlopuzyan.mobilebanking.domain.repository.AppSettingsRepository

class SetAppLocaleUseCase(
    val appSettingsRepository: AppSettingsRepository,
) {
    operator fun invoke(locale: String) {
        return appSettingsRepository.saveAppLocale(locale)
    }
}