package com.example.deliveryapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.delivery_app.auth.SignIn
import com.example.delivery_app.auth.SignUP
import com.example.deliveryapp.HomeScreen
import com.example.deliveryapp.auth.ui.Welcome
import com.example.deliveryapp.dashBoard.AccountScreen
import com.example.deliveryapp.dashBoard.Orders.DeliveryScreen
import com.example.deliveryapp.dashBoard.Orders.OrderScreen
import com.example.userapp.features.auth.OTPVerification

enum class Routes {
    Order,
    Account,
    Welcome,
    SignIn,
    OtpVerification,
    SignUp,
    HomeScreen,
    DeliveryScreen
}

@Composable
fun NavLibrary() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.SignIn.name,
    ) {
        composable(Routes.SignIn.name){
            SignIn(modifier = Modifier, navController = navController)
        }
        composable(Routes.OtpVerification.name){
            OTPVerification(navController = navController)
        }
        composable(Routes.Order.name) {
            OrderScreen(navController = navController)
        }
        composable(Routes.DeliveryScreen.name) {
            DeliveryScreen(navController = navController)
        }
        composable(Routes.Account.name) {
            AccountScreen(modifier = Modifier)
        }
        composable(Routes.HomeScreen.name){
            HomeScreen(navController = navController)
        }
    }
}