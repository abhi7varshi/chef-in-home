package com.example.chefapp.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chefapp.R
import com.example.chefapp.data.FoodItem
import com.example.chefapp.data.OrderInfo
import com.example.chefapp.data.OrderStatus
import com.example.chefapp.ui.theme.ChefAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    isDarkModeEnabled: Boolean,
    orders: List<OrderInfo>,
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabTitles = listOf("Orders", "Ready", "Pickup")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (isDarkModeEnabled) {
            // Segmented Button Row
            SingleChoiceSegmentedButtonRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                tabTitles.forEachIndexed { index, title ->
                    SegmentedButton(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        shape = SegmentedButtonDefaults.itemShape(index, tabTitles.size),
                        colors = SegmentedButtonDefaults.colors(),
                    ) {
                        Text(text = title, fontSize = 16.sp)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Tab Content Based on Selection
            when (selectedTabIndex) {
                0 -> OrdersList(orders.filter { it.status == OrderStatus.NEW })
                1 -> ReadyList(orders.filter { it.status == OrderStatus.READY })
                2 -> PickupList(orders.filter { it.status == OrderStatus.PICKED_UP })
            }
        } else {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.offline),
                    contentDescription = "Offline"
                )
            }
        }

    }
}

@Composable
fun OrdersList(orders: List<OrderInfo>) {
    if (orders.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("No new orders")
        }
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(orders) { order ->
                OrderInfoCard(order = order)
            }
        }
    }
}

@Composable
fun ReadyList(orders: List<OrderInfo>) {
    if (orders.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("No orders ready for pickup")
        }
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(orders) { order ->
                OrderInfoCard(order = order)
            }
        }
    }
}

@Composable
fun PickupList(orders: List<OrderInfo>) {
    if (orders.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("No picked up orders")
        }
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(orders) { order ->
                OrderInfoCard(order = order)
            }
        }
    }
}

// Update your preview to include the status
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val sampleOrders = listOf(
        OrderInfo(
            id = "4002",
            time = "8:00 PM",
            items = listOf(
                FoodItem(
                    name = "Food Item 1",
                    price = 200,
                    quantity = 1,
                    isVeg = true,
                    imageResId = R.drawable.dummy_food_image
                ),
                FoodItem(
                    name = "Food Item 2",
                    price = 300,
                    quantity = 2,
                    isVeg = false,
                    imageResId = R.drawable.dummy_food_image
                )
            ),
            status = OrderStatus.NEW
        ),
        OrderInfo(
            id = "4003",
            time = "9:00 PM",
            items = listOf(
                FoodItem(
                    name = "Food Item 3",
                    price = 200,
                    quantity = 1,
                    isVeg = true,
                    imageResId = R.drawable.dummy_food_image
                )
            ),
            status = OrderStatus.READY
        )
    )

    ChefAppTheme {
        HomeContent(
            isDarkModeEnabled = true,
            orders = sampleOrders,
        )
    }
}