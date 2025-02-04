@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.userapp

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.example.userapp.features.auth.LoginScreen
import com.example.userapp.features.homeScreen.HomeScreen
import com.example.userapp.ui.theme.UserAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue
import com.example.userapp.viewmodels.SplashScreenVm


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: SplashScreenVm by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen().setKeepOnScreenCondition {
            viewModel.isLoading.value
        }

        setContent {
            UserAppTheme {
//                LoginScreen()
                HomeScreen()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UserAppTheme {
        LoginScreen()
    }
}