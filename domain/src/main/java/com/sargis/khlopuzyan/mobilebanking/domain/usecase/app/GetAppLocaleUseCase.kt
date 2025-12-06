package com.sargis.khlopuzyan.mobilebanking.domain.usecase.app

import com.sargis.khlopuzyan.mobilebanking.domain.repository.AppSettingsRepository
import java.util.Locale

class GetAppLocaleUseCase(
    val appSettingsRepository: AppSettingsRepository,
) {
    operator fun invoke(): String {
        return appSettingsRepository.getAppLocale() ?: Locale.ENGLISH.displayName
    }
}