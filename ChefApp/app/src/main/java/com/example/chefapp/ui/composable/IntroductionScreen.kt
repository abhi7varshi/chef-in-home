package com.example.chefapp.ui.composable

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.chefapp.HomeRoute
import com.example.chefapp.LoginRoute
import com.example.chefapp.R
import com.example.chefapp.SignUpRoute
import com.example.chefapp.ui.theme.PrimaryColor
import com.example.chefapp.ui.viewModel.AuthState
import com.example.chefapp.ui.viewModel.AuthViewModel
import kotlinx.coroutines.delay

@Composable
fun IntroductionScreen(
    navController: NavController,
    viewModel: AuthViewModel,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
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

        Box(
            modifier = Modifier
                .weight(0.8f) // Takes 80% of the screen
                .fillMaxWidth()
        ) {
            Carousel(
                images = listOf(
                    R.drawable.image1,
                    R.drawable.image2,
                    R.drawable.image3
                )
            )
        }
        Box(
            modifier = Modifier
                .weight(0.2f) // Takes 20% of the screen
                .fillMaxWidth()
        ) {
            Column {
                Spacer(modifier = Modifier.padding(8.dp))
                // Login
                OutlinedButton(
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor),
                    onClick = {
                        navController.navigate(LoginRoute)
                    },
                    modifier = Modifier
                        .padding(8.dp)
                        .padding(horizontal = 22.dp)
                        .fillMaxWidth()
                ) { Text("Login") }

                // Sign-Up
                OutlinedButton(
                    border = androidx.compose.foundation.BorderStroke(1.dp, Color.Black),
                    onClick = {
                        navController.navigate(SignUpRoute)
                    },
                    modifier = Modifier
                        .padding(2.dp)
                        .padding(horizontal = 28.dp)
                        .fillMaxWidth()
                ) { Text("Sign up", color = Color.Black) }
            }

        }
    }

}

@Composable
fun Carousel(images: List<Int>) {
    // State to track the current image index
    val currentImageIndex = remember { mutableStateOf(0) }

    // Automatically change the image every 3 seconds
    LaunchedEffect(key1 = currentImageIndex.value) {
        delay(3000L) // Wait for the specified delay
        currentImageIndex.value =
            (currentImageIndex.value + 1) % images.size // Cycle through images
    }

    // Display the current image
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = images[currentImageIndex.value]),
            contentDescription = "Carousel Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = androidx.compose.ui.layout.ContentScale.Crop // Crop the image to fit
        )

        Spacer(modifier = Modifier.height(100.dp))

        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(bottom = 36.dp)
                .height(350.dp)
                .width(300.dp),
            // .border(androidx.compose.foundation.BorderStroke(1.dp, Color.Red)),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Spacer(modifier = Modifier.height(75.dp))

                Image(
                    painter = painterResource(R.drawable.chef_app_logo_2_1),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .width(200.dp)
                        .height(200.dp)
                )
                Text(
                    text = "Welcome to Chef App",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .background(
                            Color.Black.copy(alpha = 0.2f),
                            shape = RoundedCornerShape(24.dp)
                        )
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                )

            }
        }

        // Dots indicator at the bottom
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter) // Align dots at the bottom center
                .padding(bottom = 16.dp), // Add padding to separate from the edge
        ) {
            images.forEachIndexed { index, _ ->
                Box(
                    modifier = Modifier
                        .size(if (currentImageIndex.value == index) 16.dp else 16.dp) // Bigger dot for active image
                        .padding(4.dp) // Space between dots
                        .clip(androidx.compose.foundation.shape.CircleShape) // Circular shape for dots
                        .background(
                            if (currentImageIndex.value == index) Color.White else Color.Gray
                        ) // Dynamic color for active/inactive dots
                )
            }
        }
    }
}

@Preview
@Composable
fun IntroductionScreenPreview() {
    IntroductionScreen(navController = rememberNavController(), viewModel = viewModel())
}