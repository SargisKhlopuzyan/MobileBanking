package com.sargis.khlopuzyan.mobilebanking.domain.di

import com.sargis.khlopuzyan.mobilebanking.domain.usecase.app.GetAppLocaleUseCase
import com.sargis.khlopuzyan.mobilebanking.domain.usecase.app.SetAppLocaleUseCase
import com.sargis.khlopuzyan.mobilebanking.domain.usecase.login.DeleteUserUseCase
import com.sargis.khlopuzyan.mobilebanking.domain.usecase.login.GetLastSignedInUsernameUseCase
import com.sargis.khlopuzyan.mobilebanking.domain.usecase.login.GetUserByUsernameUseCase
import com.sargis.khlopuzyan.mobilebanking.domain.usecase.login.LoginUserUseCase
import com.sargis.khlopuzyan.mobilebanking.domain.usecase.login.ObserveAllUsersUseCase
import com.sargis.khlopuzyan.mobilebanking.domain.usecase.login.RegisterUserUseCase
import com.sargis.khlopuzyan.mobilebanking.domain.util.NameValidator
import com.sargis.khlopuzyan.mobilebanking.domain.util.PasswordValidator
import com.sargis.khlopuzyan.mobilebanking.domain.util.UsernameValidator
import org.koin.dsl.module

private val useCasesModule = module {
    single<GetAppLocaleUseCase> { GetAppLocaleUseCase(get()) }
    single<SetAppLocaleUseCase> { SetAppLocaleUseCase(get()) }
    single<GetLastSignedInUsernameUseCase> { GetLastSignedInUsernameUseCase(get()) }
    single<LoginUserUseCase> { LoginUserUseCase(get(), get(), get()) }
    single<RegisterUserUseCase> { RegisterUserUseCase(get(), get(), get(), get()) }
    single<ObserveAllUsersUseCase> { ObserveAllUsersUseCase(get()) }
    single<GetUserByUsernameUseCase> { GetUserByUsernameUseCase(get()) }
    single<DeleteUserUseCase> { DeleteUserUseCase(get()) }
}

private val validatorsModule = module {
    single<UsernameValidator> {
        UsernameValidator
    }
    single<NameValidator> {
        NameValidator
    }
    single<PasswordValidator> {
        PasswordValidator
    }
}

val domainModule = listOf(useCasesModule, validatorsModule)
