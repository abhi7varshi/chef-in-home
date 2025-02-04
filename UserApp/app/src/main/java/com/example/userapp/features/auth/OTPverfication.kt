@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.userapp.features.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.userapp.composables.OtpInput
import com.example.userapp.composables.UAButton
import com.example.userapp.ui.theme.UserAppTheme

@Composable
fun OTPVerification(
    number: String,
    navController: NavController
) {
    var otp by remember { mutableStateOf("") }
    Scaffold(topBar = {
        TopAppBar(
            title = {
                ""
            },
            navigationIcon = { Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null) }
        )
    }) { innerPadding ->

        Column(modifier = Modifier.padding(innerPadding).padding(horizontal = 16.dp)) {

            Text(text = "Verify your OTP", style = MaterialTheme.typography.titleLarge)
            Text(text = "Verification code has been sent to +91 $number")
            Spacer(modifier = Modifier.height(8.dp))
            OtpInput(otpValue = otp, onOtpChange = {otp = it})
            Spacer(Modifier.weight(1f))
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = "Didn't get the OTP?")
                TextButton(onClick = {}) { Text(text = "Resend in 25s") }
            }
            UAButton(
                text = "Verify",
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 24.dp)
            )
        }
    }
}

@Preview
@Composable
private fun OTPVerificationPreview() {
    UserAppTheme {
        OTPVerification("7776810029", navController = rememberNavController())
    }
}