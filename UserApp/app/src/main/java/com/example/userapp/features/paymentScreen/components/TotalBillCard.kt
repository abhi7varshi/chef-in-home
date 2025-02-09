package com.example.userapp.features.paymentScreen.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
    var expanded by remember { mutableStateOf(false) }

    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { expanded = !expanded }
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Left: Receipt Icon
                Image(
                    painter = painterResource(R.drawable.receipt_text),
                    contentDescription = "Receipt Icon",
                    modifier = Modifier.size(24.dp)
                )

                // Center: Text
                Text(
                    text = "Total Bill ₹112",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )

                // Right: Expand/Collapse Icon
                Icon(
                    imageVector = if (expanded) Icons.Outlined.KeyboardArrowDown else Icons.Outlined.KeyboardArrowRight,
                    contentDescription = "Expand/Collapse",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            }

            AnimatedVisibility(visible = expanded) {
                Column(modifier = Modifier.padding(top = 12.dp)) {
                    BillDetailRow("Order Total", "₹89")
                    BillDetailRow("Taxes & Charges", "₹13")
                    BillDetailRow("Delivery Fees", "₹10")
                    Divider(modifier = Modifier.padding(vertical = 4.dp))
                    BillDetailRow("To Pay", "₹112", isTotal = true)
                }
            }
        }
    }
}

@Composable
fun BillDetailRow(label: String, amount: String, isTotal: Boolean = false) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = if (isTotal) MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.primary)
            else MaterialTheme.typography.bodyMedium
        )
        Text(
            text = amount,
            style = if (isTotal) MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.primary)
            else MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
fun TotalCardPreview() {
    TotalBillCard()
}
