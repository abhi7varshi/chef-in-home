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
import com.example.chefapp.ui.composable.EditDishScreen
import com.example.chefapp.ui.composable.HomeScreen
import com.example.chefapp.ui.composable.IntroductionScreen
import com.example.chefapp.ui.composable.LoginScreen
import com.example.chefapp.ui.composable.SignUpScreen
import com.example.chefapp.ui.viewModel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           val navController = rememberNavController()

            NavHost(navController = navController, startDestination = LoginRoute){

                composable<IntroductionRoute>{
                    IntroductionScreen(navController = navController, viewModel = AuthViewModel())
                }

                composable<LoginRoute>{
                    LoginScreen(navController = navController, viewModel = AuthViewModel())
                }

                composable<SignUpRoute>{
                    SignUpScreen(navController = navController, viewModel = AuthViewModel())
                }

                composable<HomeRoute>{
                    HomeScreen(navController = navController)
                }

                composable<AddDishRoute>{
                    AddDishScreen(navController = navController)
                }

                composable<EditDishRoute>{
                    EditDishScreen(navController = navController)
                }
            }
        }
    }
}