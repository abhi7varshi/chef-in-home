package com.example.userapp.features.paymentScreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
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
fun PaymentScreenLocationCard() {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(0.5.dp, Color.Gray ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            // Location Icon
            Image(
                painter = painterResource(R.drawable.location_on),
                contentDescription = "Location On",
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 12.dp)
            )

            // Text Column
            Column(
                modifier = Modifier.weight(1f), // Take remaining space
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Hotel",
                    textAlign = TextAlign.Start,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Sri Dhanalakshmi Luxury PG for Gents,...",
                    textAlign = TextAlign.Start,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview
@Composable
fun PaymentScreenLocationCardPreview() {
    PaymentScreenLocationCard()
}
