@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.userapp.features.auth.ui

import android.text.style.StyleSpan
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.userapp.composables.OtpInput
import com.example.userapp.composables.UAButton
import com.example.userapp.navigation.HomeRoute
import com.example.userapp.ui.theme.UserAppTheme

@Composable
fun OTPVerifyScreen(
    number: String,
    navController: NavHostController = rememberNavController()
) {
    var otp by remember { mutableStateOf("") }

    val annotatedString = buildAnnotatedString {
        append("Verification code has been sent to \n")
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append(number)
        }
    }

    Scaffold(topBar = {
        TopAppBar(
            title = {},
            navigationIcon = {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        )
    }) { innerPadding ->

        Column(modifier = Modifier
            .padding(innerPadding)
            .padding(horizontal = 16.dp)) {

            Text(text = "Verify your OTP", style = MaterialTheme.typography.titleLarge)
//            Text(text = "Verification code has been sent to +91 $number")
            Text(text = annotatedString)
            Spacer(modifier = Modifier.height(8.dp))
            OtpInput(otpValue = otp, onOtpChange = { otp = it })
            Spacer(Modifier.weight(1f))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Didn't get the OTP?")
                TextButton(onClick = {}) { Text(text = "Resend in 25s") }
            }
            UAButton(
                text = "Verify",
                onClick = {
                    navController.navigate(route = HomeRoute)
                },
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
        OTPVerifyScreen(number = "9632094750")
    }
}