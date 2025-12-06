package com.sargis.khlopuzyan.mobilebanking.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.sargis.khlopuzyan.mibilebanking.main.navigation.mainNavGraph
import com.sargis.khlopuzyan.mibilebanking.main.navigation.mainRoute
import com.sargis.khlopuzyan.mobilebanking.auth.navigation.AuthRoute
import com.sargis.khlopuzyan.mobilebanking.auth.navigation.authNavGraph
import com.sargis.khlopuzyan.mobilebanking.auth.navigation.authRoute

@Composable
fun AppNavigation(navHostController: NavHostController) {
    var starDestination = authRoute
    NavHost(
        navController = navHostController,
        startDestination = authRoute
    ) {
        authNavGraph(
            navController = navHostController,
            onAuthSuccess = {
                navHostController.navigate(mainRoute) {
                    navHostController.graph.findNode(starDestination)?.id?.let { starDestination ->
                        popUpTo(starDestination) {
                            inclusive = true
                        }
                    }
                    starDestination = mainRoute
                }
            }
        )

        mainNavGraph(
            navController = navHostController,
            onSignedOut = {
                navHostController.navigate(AuthRoute.Login.route) {
                    navHostController.graph.findNode(starDestination)?.id?.let { starDestination ->
                        popUpTo(starDestination) {
                            inclusive = true
                        }
                    }
                    starDestination = authRoute
                }
            }
        )
    }
}