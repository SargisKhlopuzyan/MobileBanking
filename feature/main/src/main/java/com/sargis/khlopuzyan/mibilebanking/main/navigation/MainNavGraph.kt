package com.sargis.khlopuzyan.mibilebanking.main.navigation

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sargis.khlopuzyan.mibilebanking.main.screen.MainScreen
import com.sargis.khlopuzyan.mibilebanking.main.screen.MainUIEvent
import com.sargis.khlopuzyan.mibilebanking.main.screen.MainViewModel
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.mainNavGraph(
    navController: NavController,
    onSignedOut: () -> Unit,
) {
    navigation(startDestination = MainRoute.Main.route, route = mainRoute) {
        composable(route = MainRoute.Main.route) {
            val viewModel = koinViewModel<MainViewModel>()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            MainScreen(uiState, onEvent = {
                when (it) {
                    MainUIEvent.SignedOut -> onSignedOut()
                    else -> viewModel::onEvent.invoke(it)
                }
            })
        }
    }
}