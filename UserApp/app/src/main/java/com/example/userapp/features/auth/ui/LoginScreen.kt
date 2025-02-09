package com.example.userapp.features.auth.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.userapp.R
import com.example.userapp.navigation.OTPVerifyRoute
import com.example.userapp.ui.theme.Green
import com.example.userapp.ui.theme.UserAppTheme

@Composable
fun LoginScreen(
    navController: NavController = rememberNavController(),
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Image(
                painter = painterResource(id = R.drawable.header_img),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Login or Signup",
                fontSize = 16.sp,
                fontWeight = FontWeight.W600,
                modifier = Modifier.padding(start = 20.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                placeholder = { Text(text = "Enter your Number", fontSize = 16.sp) },
                value = "",
                onValueChange = {},
                shape = ShapeDefaults.Medium,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Black.copy(
                        alpha = 0.16f
                    )
                ),
                leadingIcon = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Spacer(modifier = Modifier.width(16.dp))

                        Image(
                            painter = painterResource(R.drawable.india_flag_icon),
                            contentDescription = null,
                            modifier = Modifier
                                .height(16.dp)
                                .width(16.dp)
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(text = "+91", fontSize = 16.sp, fontWeight = FontWeight.W400)

                        Spacer(modifier = Modifier.width(16.dp))

                        Text(text = "|", fontSize = 20.sp)

                        Spacer(modifier = Modifier.width(8.dp))
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    loginViewModel.register("", "", "")
                    navController.navigate(route = OTPVerifyRoute(phoneNumber = "9632094750"))
                },
                shape = ShapeDefaults.Medium,
                colors = ButtonDefaults.buttonColors(containerColor = Green),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Text(
                    text = "Continue",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "By clicking in, I accept the terms of service & privacy policy.",
                fontSize = 10.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                HorizontalDivider(
                    modifier = Modifier
                        .width(177.dp)
                        .padding(start = 20.dp)
                )

                Spacer(Modifier.width(9.dp))

                Text(
                    text = "or",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                )

                Spacer(Modifier.width(9.dp))

                HorizontalDivider(
                    modifier = Modifier
                        .width(177.dp)
                        .padding(end = 20.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedButton(
                onClick = {
                    //navigate to location.
                },
                shape = ShapeDefaults.Medium,
                border = BorderStroke(width = 1.dp, color = Color.Black.copy(alpha = 0.16f)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(R.drawable.google_logo),
                        contentDescription = "",
                        modifier = Modifier
                            .width(16.dp)
                            .height(16.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Continue with Google",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500,
                        color = Green,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    UserAppTheme {
        LoginScreen()
    }
}