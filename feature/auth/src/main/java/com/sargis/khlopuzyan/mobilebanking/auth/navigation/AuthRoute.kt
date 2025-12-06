package com.sargis.khlopuzyan.mobilebanking.auth.navigation

const val authRoute = "auth"

sealed class AuthRoute(val route: String) {
    object LoginMain : AuthRoute("$authRoute/login_main")
    object Login : AuthRoute("$authRoute/login")
    object OnlineRegistration : AuthRoute("$authRoute/online_registration")
    object Rates : AuthRoute("$authRoute/rates")
    object Map : AuthRoute("$authRoute/map")
    object News : AuthRoute("$authRoute/news")
    object About : AuthRoute("$authRoute/about")
    object ResetPassword : AuthRoute("$authRoute/reset_password")
    object SignInConfiguration : AuthRoute("$authRoute/sign_in_configuration")
    object LoginWithAnotherAccount : AuthRoute("$authRoute/login_with_another_account")
}