@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.userapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.userapp.features.Navigation.NavLibrary
import com.example.userapp.features.auth.LoginScreen
import com.example.userapp.ui.theme.UserAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UserAppTheme {
                NavLibrary()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UserAppTheme {
        LoginScreen(navController = rememberNavController())
    }
}