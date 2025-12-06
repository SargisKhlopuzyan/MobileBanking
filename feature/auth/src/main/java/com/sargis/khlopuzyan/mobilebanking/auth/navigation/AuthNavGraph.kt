package com.sargis.khlopuzyan.mobilebanking.auth.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sargis.khlopuzyan.mobilebanking.auth.screen.about.AboutScreen
import com.sargis.khlopuzyan.mobilebanking.auth.screen.about.AboutUIEvent
import com.sargis.khlopuzyan.mobilebanking.auth.screen.about.AboutViewModel
import com.sargis.khlopuzyan.mobilebanking.auth.screen.login.LoginNavigationEvent
import com.sargis.khlopuzyan.mobilebanking.auth.screen.login.LoginScreen
import com.sargis.khlopuzyan.mobilebanking.auth.screen.login.LoginUIEvent
import com.sargis.khlopuzyan.mobilebanking.auth.screen.login.LoginViewModel
import com.sargis.khlopuzyan.mobilebanking.auth.screen.loginMain.LoginMainScreen
import com.sargis.khlopuzyan.mobilebanking.auth.screen.loginMain.LoginMainUIEvent
import com.sargis.khlopuzyan.mobilebanking.auth.screen.loginMain.LoginMainViewModel
import com.sargis.khlopuzyan.mobilebanking.auth.screen.map.MapScreen
import com.sargis.khlopuzyan.mobilebanking.auth.screen.map.MapUIEvent
import com.sargis.khlopuzyan.mobilebanking.auth.screen.map.MapViewModel
import com.sargis.khlopuzyan.mobilebanking.auth.screen.news.NewsScreen
import com.sargis.khlopuzyan.mobilebanking.auth.screen.news.NewsUIEvent
import com.sargis.khlopuzyan.mobilebanking.auth.screen.news.NewsViewModel
import com.sargis.khlopuzyan.mobilebanking.auth.screen.rates.RatesScreen
import com.sargis.khlopuzyan.mobilebanking.auth.screen.rates.RatesUIEvent
import com.sargis.khlopuzyan.mobilebanking.auth.screen.rates.RatesViewModel
import com.sargis.khlopuzyan.mobilebanking.auth.screen.registration.RegistrationNavigationEvent
import com.sargis.khlopuzyan.mobilebanking.auth.screen.registration.RegistrationScreen
import com.sargis.khlopuzyan.mobilebanking.auth.screen.registration.RegistrationViewModel
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.authNavGraph(
    navController: NavController,
    onAuthSuccess: (userId: Int) -> Unit,
) {
    navigation(startDestination = AuthRoute.LoginMain.route, route = authRoute) {
        composable(route = AuthRoute.LoginMain.route) {
            val viewModel = koinViewModel<LoginMainViewModel>()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()

//            LaunchedEffect(Unit) {
//                viewModel.navigationEvent.collect { event ->
//                    when (event) {
//                        LoginMainNavigationEvent.NavigateUp -> navController.popBackStack()
//                        is LoginMainNavigationEvent.AuthSuccess -> {
//                            onAuthSuccess(event.userId)
//                        }
//                    }
//                }
//            }

            LoginMainScreen(
                uiState = uiState,
                onItemClick = { route ->
                    navController.navigate(route)
                },
                onEvent = {
                    when (it) {
                        is LoginMainUIEvent.ChangeLocale -> {
                            viewModel::onEvent.invoke(it)
                        }

                        LoginMainUIEvent.ChooseLocale -> {
                            //
                        }

                        LoginMainUIEvent.Login -> navController.navigate(AuthRoute.Login.route)
                        LoginMainUIEvent.OnlineRegistration -> navController.navigate(AuthRoute.OnlineRegistration.route)
                        LoginMainUIEvent.About -> navController.navigate(AuthRoute.About.route)
                        LoginMainUIEvent.Maps -> navController.navigate(AuthRoute.Map.route)
                        LoginMainUIEvent.News -> navController.navigate(AuthRoute.News.route)
                        LoginMainUIEvent.Rates -> navController.navigate(AuthRoute.Rates.route)
                    }
                })
        }

        composable(route = AuthRoute.Rates.route) {
            val viewModel: RatesViewModel = koinViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()

            RatesScreen(uiState, onEvent = {
//                when (it) {
//                    RatesUIEvent.NavigateUp -> navController.popBackStack()
//                }
            })
        }

        composable(route = AuthRoute.Map.route) {
            val viewModel: MapViewModel = koinViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()

            MapScreen(uiState, onEvent = {
//                when (it) {
//                    MapUIEvent.NavigateUp -> navController.popBackStack()
//                }
            })
        }

        composable(route = AuthRoute.News.route) {
            val viewModel: NewsViewModel = koinViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()

            NewsScreen(uiState, onEvent = {
//                when (it) {
//                    NewsUIEvent.NavigateUp -> navController.popBackStack()
//                }
            })
        }

        composable(route = AuthRoute.About.route) {
            val viewModel: AboutViewModel = koinViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()

            AboutScreen(uiState, onEvent = {
//                when (it) {
//                    AboutUIEvent.NavigateUp -> navController.popBackStack()
//                }
            })
        }

        composable(route = AuthRoute.Login.route) {
            val viewModel: LoginViewModel = koinViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()

            LaunchedEffect(Unit) {
                viewModel.navigationEvent.collect { event ->
                    when (event) {
                        LoginNavigationEvent.NavigateUp -> navController.popBackStack()
                        is LoginNavigationEvent.AuthSuccess -> {
                            onAuthSuccess(event.userId)
                        }
                    }
                }
            }

            LoginScreen(uiState, onEvent = {
                when (it) {
                    LoginUIEvent.NavigateUp -> navController.popBackStack()
                    LoginUIEvent.Register -> navController.navigate(AuthRoute.OnlineRegistration.route)
                    is LoginUIEvent.Login -> {
                        viewModel::onEvent.invoke(it)
                    }
                }
            })
        }

        composable(route = AuthRoute.OnlineRegistration.route) {
            val viewModel: RegistrationViewModel = koinViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()

            LaunchedEffect(Unit) {
                viewModel.navigationEvent.collect { event ->
                    when (event) {
                        RegistrationNavigationEvent.NavigateUp -> navController.popBackStack()
                        is RegistrationNavigationEvent.Registered -> {
                            onAuthSuccess(event.userId)
                        }
                    }
                }
            }

            RegistrationScreen(uiState, onEvent = {
                viewModel::onEvent.invoke(it)
            })
        }
    }
}