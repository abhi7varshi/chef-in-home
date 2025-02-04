package com.example.userapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.userapp.features.homeScreen.HomeScreen

@Composable
fun Navigation(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HomeScreenRoute){
        composable<HomeScreenRoute>{
            HomeScreen()
        }
    }

}