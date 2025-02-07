package com.example.userapp.features.paymentScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.userapp.R

@Composable
fun TotalBillCard() {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left: Discount Icon
            Image(
                painter = painterResource(R.drawable.receipt_text),
                contentDescription = "Discount Icon",
                modifier = Modifier.size(24.dp)
            )

            // Center: Text
            Text(
                text = "Total Bill ₹89",
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )

            // Right: Arrow Icon
            Icon(
                imageVector = Icons.Outlined.KeyboardArrowRight,
                contentDescription = "Forward Arrow",
                tint = Color.Black,
                modifier = Modifier.size(24.dp) // Adjust size if needed
            )
        }

    }
}

@Preview
@Composable
fun TotalCardPreview() {
    TotalBillCard()
}