package com.example.userapp.features.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.userapp.features.auth.LoginScreen
import com.example.userapp.features.auth.OTPVerification

enum class Routes {
    SignIn,
    OtpVerification,
    DashBoard
}
sealed class DefinedRoutes(val name: String) {
    object SignIn : DefinedRoutes("signIn")
    object OtpVerification : DefinedRoutes("otpVerification/{phoneNumber}") // Define argument
}

@Composable
fun NavLibrary() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.SignIn.name
    ){
        composable (Routes.SignIn.name) {
            LoginScreen(navController = navController)
        }
        composable("otpVerification/{phoneNumber}") { backStackEntry ->
            val phoneNumber = backStackEntry.arguments?.getString("phoneNumber") ?: ""
            OTPVerification(number = phoneNumber, navController = navController)
        }
    }
}