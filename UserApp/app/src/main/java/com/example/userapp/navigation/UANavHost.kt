package com.example.userapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.userapp.features.auth.ui.LoginScreen
import com.example.userapp.features.auth.ui.OTPVerifyScreen

@Composable
fun UANavHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = LoginRoute) {
        composable<LoginRoute> {
            LoginScreen(navController = navController)
        }

        composable<OTPVerifyRoute> {
            OTPVerifyScreen(navController = navController)
        }
    }
}