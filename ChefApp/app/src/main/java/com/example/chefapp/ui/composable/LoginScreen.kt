package com.example.chefapp.ui.composable

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.chefapp.ui.viewModel.AuthState
import com.example.chefapp.ui.viewModel.AuthViewModel
import com.example.chefapp.HomeRoute
import com.example.chefapp.R
import com.example.chefapp.SignUpRoute

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: AuthViewModel
) {

    Scaffold { innerPadding ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            val context = LocalContext.current

            // Observe authState
            val authState = viewModel.authState.observeAsState().value

            // Handle authState with LaunchedEffect
            LaunchedEffect(authState) {
                when (authState) {
                    is AuthState.Authenticated -> {
                        navController.navigate(HomeRoute) {
                            popUpTo(0) // Clear back stack
                        }
                    }
                    is AuthState.Error -> {
                        Toast.makeText(context, authState.message, Toast.LENGTH_SHORT).show()
                    }
                    AuthState.Loading -> {
                        // Optionally show a loading indicator
                        Toast.makeText(context, "Loading...", Toast.LENGTH_SHORT).show()
                    }
                    AuthState.Unauthenticated -> {
                        // Stay on login screen or take additional actions
                    }
                    null -> {
                        // Handle null state if necessary
                    }
                }
            }

            // State variables for email and password input
            val email = remember { mutableStateOf("") }
            val password = remember { mutableStateOf("") }
            val passwordVisible = remember { mutableStateOf(false) }

            Image(
                painter = painterResource(id = R.drawable.chef_app_logo_1),
                contentDescription = "Logo",
                modifier = Modifier.size(250.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(text = "Chef App", fontSize = 28.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(32.dp))

            Text(text = "Login to your account")

            Spacer(modifier = Modifier.height(8.dp))

            // Email Input Field
            OutlinedTextField(
                value = email.value,
                onValueChange = { email.value = it },
                label = { Text(text = "Email") },
                placeholder = { Text(text = "Enter your email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 52.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password Input Field
            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text(text = "Password") },
                placeholder = { Text(text = "Enter your password") },
                visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val imageResource = if (passwordVisible.value)
                        R.drawable.visibility // Use the vector drawable for visibility
                    else
                        R.drawable.visibility_off // Use the vector drawable for visibility_off
                    Image(
                        painter = painterResource(id = imageResource),
                        contentDescription = if (passwordVisible.value) "Hide password" else "Show password",
                        modifier = Modifier
                            .clickable { passwordVisible.value = !passwordVisible.value }
                            .padding(8.dp)
                    )
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 52.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    viewModel.login(email.value, password.value)
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 52.dp)
            ) {
                Text(text = "Login")
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Forgot Password?",
                modifier = Modifier.clickable {
                    Toast.makeText(context, "Forgot Password Pressed", Toast.LENGTH_SHORT).show()
                }
            )

            Spacer(modifier = Modifier.height(32.dp))

            TextButton(onClick = {
                 navController.navigate(route = SignUpRoute)
            }) {Text(text = "Don't have an account? Sign up") }

        }
    }
}


@Composable
@Preview
fun LoginScreenPreview(){
    LoginScreen(
        navController = NavController(LocalContext.current),
        viewModel = AuthViewModel()
    )
}