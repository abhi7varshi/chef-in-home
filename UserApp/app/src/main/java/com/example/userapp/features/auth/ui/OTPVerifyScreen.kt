@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.userapp.features.auth.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.userapp.composables.UAButton
import com.example.userapp.ui.theme.UserAppTheme

@Composable
fun OTPVerifyScreen(
    navController: NavController = rememberNavController()
) {
    Scaffold(topBar = {
        TopAppBar(
            title = {},
            navigationIcon = {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = null
                    )
                }
            })
    }) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "Verify your OTP")
            Text(text = "Verification code has been sent to +91 9900445566")
            Spacer(Modifier.weight(1f))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Didn't get the OTP?")
                TextButton(onClick = {}) { Text(text = "Resend in 25s") }
            }
            UAButton(
                text = "Verify",
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 20.dp)
            )
        }
    }
}

@Preview
@Composable
private fun OTPVerificationPreview() {
    UserAppTheme {
        OTPVerifyScreen()
    }
}