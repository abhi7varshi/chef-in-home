@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.userapp.features.auth

import android.util.Log
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
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.deliveryapp.common_reusable_ui.OtpInput
import com.example.deliveryapp.common_reusable_ui.UAButton
import com.example.deliveryapp.navigation.Routes
import kotlinx.coroutines.launch

@Composable
fun OTPVerification(
    navController: NavController
) {
    var otp by remember { mutableStateOf("") }
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold( snackbarHost = { SnackbarHost(snackbarHostState) },topBar = {
        TopAppBar(
            title = {
                ""
            },
            navigationIcon = { Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, modifier = Modifier.padding(horizontal = 16.dp)) }
        )
    }) { innerPadding ->
        val coroutine = rememberCoroutineScope()

        Column(modifier = Modifier.padding(innerPadding).padding(horizontal = 16.dp)) {

            Text(text = "Verify your OTP", style = MaterialTheme.typography.titleLarge)
            Text(text = "Verification code has been sent to +917776810029")
            Spacer(modifier = Modifier.height(8.dp))
            OtpInput(otpValue = otp, onOtpChange = {otp = it})
            Spacer(Modifier.weight(1f))
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = "Didn't get the OTP?")
                TextButton(onClick = {}) { Text(text = "Resend in 25s") }
            }
            UAButton(
                text = "Verify",
                onClick = {
                    Log.d("OTp lenth bata >> ${otp.length}","OTp lenth bata >> ${otp.length}")
                    if (otp.length==6){
                        navController.navigate(Routes.HomeScreen.name)
                    }
                    else
                    {
                        coroutine.launch {
                            snackbarHostState.showSnackbar("Enter a valid 6 digit otp.")
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 24.dp)
            )
        }
    }
}