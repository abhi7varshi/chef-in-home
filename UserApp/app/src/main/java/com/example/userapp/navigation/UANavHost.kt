package com.example.userapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.userapp.composables.LandingScreen
import com.example.userapp.features.account.AccountScreen
import com.example.userapp.features.auth.ui.LoginScreen
import com.example.userapp.features.auth.ui.OTPVerifyScreen
import com.example.userapp.features.homeScreen.HomeScreen
import com.example.userapp.features.support.SupportScreen

@Composable
fun UANavHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = AccountScreenRoute) {
        composable<LoginRoute> {
            LoginScreen(navController = navController)
        }

        composable<OTPVerifyRoute> {
            val args = it.toRoute<OTPVerifyRoute>()

            OTPVerifyScreen(navController = navController, number = args.phoneNumber)
        }

        composable<HomeRoute> {
            LandingScreen()
        }

        composable<AccountScreenRoute>{
            AccountScreen()
        }
    }
}