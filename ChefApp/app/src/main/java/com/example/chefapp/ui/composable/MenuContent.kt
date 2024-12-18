package com.example.chefapp.ui.composable

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chefapp.data.OrderInfo

@Composable
fun MenuContent(orders: List<OrderInfo>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        items(orders) { order ->
            OrderInfoCard(order = order)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MenuContentPreview() {
    val sampleOrders = listOf(
        OrderInfo(
            id = "4002",
            time = "8:00 PM",
            items = listOf(
                "Food Item 1" to 200,
                "Food Item 2" to 200
            ),
            totalBill = 400
        ),
        OrderInfo(
            id = "4003",
            time = "9:00 PM",
            items = listOf(
                "Food Item 3" to 250,
                "Food Item 4" to 150
            ),
            totalBill = 400
        )
    )
    MenuContent(orders = sampleOrders)
}
