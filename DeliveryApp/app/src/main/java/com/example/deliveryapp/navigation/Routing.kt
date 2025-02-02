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
import com.example.deliveryapp.dashBoard.Orders.OrderScreen

enum class Routes {
    Order,
    Account,
    Welcome,
    SignIn,
    SignUp,
    HomeScreen,
}

@Composable
fun NavLibrary() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Welcome.name,
    ) {
        composable (Routes.Welcome.name) {
            Welcome(navController = navController)
        }
        composable(Routes.SignIn.name){
            SignIn(modifier = Modifier, navController = navController)
        }
        composable(Routes.SignUp.name){
            SignUP(modifier = Modifier, navController = navController)
        }
        composable(Routes.Order.name) {
            OrderScreen(modifier = Modifier)
        }
        composable(Routes.Account.name) {
            AccountScreen(modifier = Modifier)
        }
        composable(Routes.HomeScreen.name){
            HomeScreen()
        }
    }
}