package com.example.chefapp.ui.composable

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.chefapp.LoginRoute
import com.example.chefapp.ui.viewModel.AuthState
import com.example.chefapp.ui.viewModel.AuthViewModel
import com.example.chefapp.R
import com.example.chefapp.ui.theme.PrimaryColor

@Composable
fun SettingsContent(
    navController: NavController,
    authViewModel: AuthViewModel
) {
    val authState = authViewModel.authState.observeAsState().value
    LaunchedEffect(authState) {
        when (authState) {
            is AuthState.Unauthenticated -> {
                navController.navigate(LoginRoute)
            }

            else -> {
                Log.d("SettingsContent", "Unknown auth state: $authState")
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.padding(4.dp))

        OutlinedCard(
            colors = androidx.compose.material3.CardDefaults.cardColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                androidx.compose.foundation.Image(
                    painter = androidx.compose.ui.res.painterResource(id = R.drawable.avatar),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(80.dp)
                        .padding(end = 16.dp)
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Name: John Doe",
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                    Text(
                        text = "Phone: +1234567890",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = "Email: john.doe@example.com",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                }
            }
        }

        Spacer(modifier = Modifier.padding(4.dp))

        OutlinedCard(
            onClick = {},
            colors = androidx.compose.material3.CardDefaults.cardColors(
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
            colors = androidx.compose.material3.CardDefaults.cardColors(
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
            colors = androidx.compose.material3.CardDefaults.cardColors(
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
            colors = androidx.compose.material3.CardDefaults.cardColors(
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
            colors = androidx.compose.material3.CardDefaults.cardColors(
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
            onClick = { /* Handle add dish action */ },
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
