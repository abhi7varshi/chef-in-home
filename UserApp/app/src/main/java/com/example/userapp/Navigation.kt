package com.example.userapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.userapp.features.paymentScreen.PaymentScreen
import com.example.userapp.features.homeScreen.HomeScreen
import com.example.userapp.features.reorderScreen.ReOrderScreen
import com.example.userapp.features.restaurantScreen.RestaurantScreen

@Composable
fun Navigation(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ReOrderScreenRoute){
        composable<HomeScreenRoute>{
            HomeScreen()
        }

        composable<RestaurantScreenRoute>{
            RestaurantScreen()
        }

        composable<PaymentScreenRoute>{
            PaymentScreen()
        }

        composable<ReOrderScreenRoute>{
            ReOrderScreen()
        }
    }

}