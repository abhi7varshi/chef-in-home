package com.example.deliveryapp.dashBoard.Orders

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deliveryapp.R

@Composable
fun DeliveryScreen(modifier: Modifier) {
    Box(modifier = modifier.fillMaxSize().padding(8.dp)) {
        // Map View (Full-Screen Image)
        Image(
            painter = painterResource(R.drawable.map),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFE0E0E0))
                .padding(bottom = 130.dp)
        )

        // App Bar-like Text at the top center
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp)
                .align(Alignment.TopCenter)  //0990ff
        )  {
            Text(
                text = "Navigation Map",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W600),
                color = Color.Black,
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }

        // User Info Card
        Card(
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .align(Alignment.BottomCenter)
                .padding(horizontal = 8.dp)
                .padding(bottom = 24.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // User Information
                Column {
                    Text(
                        text = "Aman Sharma",
                        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Delivery",
                        style = TextStyle(fontSize = 16.sp, color = Color.Gray),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "404, Rainbow PG, Bomanhalli, Bengaluru-650068",
                        style = TextStyle(fontSize = 14.sp, color = Color.Gray)
                    )
                }

                // Start Button
                Button(
                    onClick = { /* Start action */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0990ff))
                ) {
                    Text(
                        text = "Start",
                        style = TextStyle(fontSize = 16.sp, color = Color.White)
                    )
                }
            }
        }
    }
}




@Composable
@Preview(showBackground = true)
fun DeliveryScreenPreview() {
    DeliveryScreen(modifier = Modifier)
}
