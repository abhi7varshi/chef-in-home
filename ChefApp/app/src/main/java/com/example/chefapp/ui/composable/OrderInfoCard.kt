package com.example.chefapp.ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chefapp.data.OrderInfo

@Composable
fun OrderInfoCard(order: OrderInfo) {
    ElevatedCard(
        elevation = cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .size(width = 340.dp, height = 200.dp)
            .padding(8.dp)
    ) {
        // Header Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = "ID: ${order.id}",
                textAlign = TextAlign.Start
            )
            Text(
                text = order.time,
                textAlign = TextAlign.End
            )
        }

        HorizontalDivider(thickness = 1.dp)

        // Items List
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            order.items.forEach { item ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "{veg} 1 X ${item.first}")
                    Text(text = "₹${item.second}")
                }
            }
        }

        HorizontalDivider(thickness = 1.dp)

        // Total Bill Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Total Bill",
                textAlign = TextAlign.Start
            )
            Text(
                text = "₹${order.totalBill}",
                textAlign = TextAlign.End
            )
        }
    }
}

@Composable
@Preview
fun OrderInfoCardPreview() {
    OrderInfoCard(
        order = OrderInfo(
            id = "4002",
            time = "8:00 PM",
            items = listOf(
                "Food Item 1" to 200,
                "Food Item 2" to 300
            ),
            totalBill = 500
        )
    )
}