package com.example.deliveryapp.auth.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.deliveryapp.R
import com.example.deliveryapp.navigation.Routes

@Composable
fun Welcome(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(
                modifier = Modifier.height(24.dp)
            )
            Image(
                painter = painterResource(R.drawable.food_menu1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = 400.dp)
            )
            Text(
                "Namma Kitchen's",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.W600,
                    fontSize = 32.sp
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                "Delivery Partner App",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.W400,
                    fontSize = 16.sp
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(
                modifier = Modifier.height(40.dp),

                )
            OutlinedButton(
                onClick = {
                     navController.navigate(Routes.SignUp.name)
                },
                shape = RoundedCornerShape(size = 12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
                    .height(48.dp)
            ) {
                Text(text = "Register Now")
            }
            Spacer(
                modifier = Modifier.height(8.dp)
            )
            Text(text = "OR")
            Spacer(
                modifier = Modifier.height(8.dp)
            )
            Text(text = "Already have an account?")
            Spacer(
                modifier = Modifier.height(24.dp)
            )
            OutlinedButton(
                onClick = {
                    navController.navigate(Routes.SignIn.name)
                },
                shape = RoundedCornerShape(size = 12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
                    .height(48.dp)
            ) {
                Text("Sign In")
            }
            Spacer(
                modifier = Modifier.height(40.dp)
            )
            Text(
                text = "By using this app, You agree's to the app's terms of use and privacy policy.",
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 40.dp)
            )
        }

    }
}

//@Composable
//@Preview(showBackground = true)
//fun showWelcome() {
//    Welcome(navController = NavController)
//}