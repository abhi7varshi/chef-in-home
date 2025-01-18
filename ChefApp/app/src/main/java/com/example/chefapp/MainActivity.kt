@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.chefapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chefapp.ui.composable.AddDishScreen
import com.example.chefapp.ui.composable.HomeScreen
import com.example.chefapp.ui.composable.LoginScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           val navController = rememberNavController()

            NavHost(navController = navController, startDestination = HomeRoute){
                composable<LoginRoute>{
                    LoginScreen(navController = navController)
                }

                composable<HomeRoute>{
                    HomeScreen(navController = navController)
                }

                composable<AddDishRoute>(){
                    AddDishScreen(navController = navController)
                }
            }
        }
    }
}