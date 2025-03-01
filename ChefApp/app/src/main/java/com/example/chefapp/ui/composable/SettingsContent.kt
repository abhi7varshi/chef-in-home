package com.example.chefapp.ui.composable

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.chefapp.LoginRoute
import com.example.chefapp.R
import com.example.chefapp.ui.theme.PrimaryColor
import com.example.chefapp.ui.viewModel.AuthState
import com.example.chefapp.ui.viewModel.AuthViewModel

@Composable
fun SettingsContent(
    navController: NavController,
    authViewModel: AuthViewModel
) {
    val authState = authViewModel.authState.observeAsState().value
//    LaunchedEffect(authState) {
//        when (authState) {
//            is AuthState.Unauthenticated -> {
//                navController.navigate(LoginRoute)
//            }
//
//            else -> {
//                Log.d("SettingsContent", "Unknown auth state: $authState")
//            }
//        }
//    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var showDialog = remember { mutableStateOf(false) }
        var name = remember { mutableStateOf("John Doe") }
        var phone = remember { mutableStateOf("+1234567890") }
        var email = remember { mutableStateOf("john.doe@example.com") }

        Spacer(modifier = Modifier.padding(4.dp))

        OutlinedCard(
            colors = cardColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(16.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                // Card content
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.avatar),
                        contentDescription = "Profile Image",
                        modifier = Modifier
                            .size(80.dp)
                            .padding(end = 16.dp)
                    )

                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Name: ${name.value}",
                            fontSize = 18.sp,
                            color = Color.Black
                        )
                        Text(
                            text = "Phone: ${phone.value}",
                            fontSize = 16.sp,
                            color = Color.Gray
                        )
                        Text(
                            text = "Email: ${email.value}",
                            fontSize = 16.sp,
                            color = Color.Gray
                        )
                    }
                }

                // Edit icon
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                        .size(24.dp)
                        .clickable { showDialog.value = true },
                    tint = Color.Gray
                )
            }
        }

        // AlertDialog for editing user details
        if (showDialog.value) {
            AlertDialog(
                onDismissRequest = { showDialog.value = false },
                title = { Text(text = "Edit Profile") },
                text = {
                    Column {
                        TextField(
                            value = name.value,
                            onValueChange = { name.value = it },
                            label = { Text("Name") },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        TextField(
                            value = phone.value, // Use phone.value
                            onValueChange = { phone.value = it },
                            label = { Text("Phone") },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        TextField(
                            value = email.value,
                            onValueChange = { email.value = it },
                            label = { Text("Email") },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                },
                confirmButton = {
                    Button(
                        onClick = { showDialog.value = false }
                    ) {
                        Text("Save")
                    }
                },
                dismissButton = {
                    Button(
                        onClick = { showDialog.value = false }
                    ) {
                        Text("Cancel")
                    }
                }
            )
        }

        Spacer(modifier = Modifier.padding(4.dp))

        OutlinedCard(
            onClick = {},
            colors = cardColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp)
        ) {
            Text(text = "Edit Profile", fontSize = 16.sp, modifier = Modifier.padding(16.dp))
        }

        Spacer(modifier = Modifier.padding(4.dp))

        OutlinedCard(
            onClick = {},
            colors = cardColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp)
        ) {
            Text(text = "Support", fontSize = 16.sp, modifier = Modifier.padding(16.dp))
        }

        Spacer(modifier = Modifier.padding(4.dp))

        OutlinedCard(
            onClick = {},
            colors = cardColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp)
        ) {
            Text(text = "FAQ", fontSize = 16.sp, modifier = Modifier.padding(16.dp))
        }

        Spacer(modifier = Modifier.padding(4.dp))

        OutlinedCard(
            onClick = {},
            colors = cardColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp)
        ) {
            Text(text = "Terms and Condition", fontSize = 16.sp, modifier = Modifier.padding(16.dp))
        }

        Spacer(modifier = Modifier.padding(4.dp))

        OutlinedCard(
            onClick = {},
            colors = cardColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp)
        ) {
            Text(text = "Privacy Policy", fontSize = 16.sp, modifier = Modifier.padding(16.dp))
        }

        Spacer(modifier = Modifier.padding(4.dp))

        // Sign Out Button
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor),
            onClick = {
                when (authState) {
                    is AuthState.Unauthenticated -> {
                        navController.navigate(LoginRoute)
                    }
                    else -> {
                        Log.d("SettingsContent", "Unknown auth state: $authState")
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Sign Out", color = Color.White)
        }
    }
}

@Preview
@Composable
fun SettingsContentPreview() {
    SettingsContent(
        navController = rememberNavController(),
        authViewModel = AuthViewModel()
    )
}
