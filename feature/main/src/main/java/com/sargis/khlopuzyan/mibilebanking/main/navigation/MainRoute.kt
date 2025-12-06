package com.sargis.khlopuzyan.mibilebanking.main.navigation

const val mainRoute = "main"

sealed class MainRoute(val route: String) {
    object Main : MainRoute("${mainRoute}/main")
}