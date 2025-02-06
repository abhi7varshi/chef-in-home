package com.example.userapp.features.auth.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.firebase.auth.FirebaseUser

@Composable
fun GoogleAndPhoneAuthScreen(
    onGoogleSignInClick: () -> Unit,
    onSignOutClick: () -> Unit,
    user: FirebaseUser?,
    viewModel: LoginViewModel = hiltViewModel()
) {
    var phoneNumber by remember { mutableStateOf("") }
    var otp by remember { mutableStateOf("") }
    val uiState by viewModel.uiState.collectAsState()


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (uiState.isLoading) {
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        }

        if (user != null) {
            Text(text = "Welcome, ${user.phoneNumber ?: user.displayName}")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onSignOutClick) {
                Text("Sign Out")
            }
        } else {
            Button(onClick = onGoogleSignInClick) {
                Text("Sign in with Google")
            }
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = { Text("Phone Number") }
            )

            Button(onClick = { viewModel.sendOTP(phoneNumber) }) {
                Text("Send OTP")
            }

            OutlinedTextField(
                value = otp,
                onValueChange = { otp = it },
                label = { Text("Enter OTP") }
            )

            Button(onClick = { viewModel.verifyOTP(otp) }) {
                Text("Verify OTP")
            }
        }
    }
}