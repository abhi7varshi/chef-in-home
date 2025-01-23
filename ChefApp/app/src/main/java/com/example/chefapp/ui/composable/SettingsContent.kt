package com.example.chefapp.ui.composable

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.chefapp.ui.viewModel.AuthState
import com.example.chefapp.ui.viewModel.AuthViewModel
import com.example.chefapp.LoginRoute

@Composable
fun SettingsContent(
    modifier: Modifier = Modifier,
    navController: NavController,
    authViewModel: AuthViewModel
) {
    val authState = authViewModel.authState.observeAsState().value
    LaunchedEffect(authState) {
        when(authState) {
            is AuthState.Unauthenticated -> {
                navController.navigate(LoginRoute)
            }

            else -> {
                Log.d("SettingsContent", "Unknown auth state: $authState")
            }
        }
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Settings Page", fontSize = 32.sp)

        TextButton(onClick = {
            authViewModel.signout()
        }) {
            Text(text = "Sign Out")

        }
    }
}