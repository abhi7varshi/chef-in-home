package com.example.userapp.features.paymentScreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.userapp.R

@Composable
fun OrderCard() {
    ElevatedCard(
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = Modifier.fillMaxWidth().padding(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            // Text Column
            Column(
                modifier = Modifier.weight(1f), // Take remaining space
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.veg_icon),
                    contentDescription = "veg/non-veg",
                    modifier = Modifier
                        .size(30.dp)
                        .padding(end = 12.dp)
                )

                Spacer(modifier = Modifier.padding(4.dp))

                Text(
                    text = "Special Idly",
                    textAlign = TextAlign.Start,
                    fontSize = 16.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.padding(4.dp))

                Text(
                    text = "₹89",
                    textAlign = TextAlign.Start,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }

            // Location Icon
            Image(
                painter = painterResource(R.drawable.location_on),
                contentDescription = "Location On",
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 12.dp)
            )
        }

        Spacer(modifier = Modifier.padding(8.dp))

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(6.dp)
        ) {
            Text(
                text = " + Add more items",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
fun OrderCardPreview() {
    OrderCard()
}