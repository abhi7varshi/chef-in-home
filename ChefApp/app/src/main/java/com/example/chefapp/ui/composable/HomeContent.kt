package com.example.chefapp.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chefapp.R
import com.example.chefapp.data.FoodItem
import com.example.chefapp.data.OrderInfo
import com.example.chefapp.ui.theme.ChefAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    isDarkModeEnabled: Boolean,
    orders: List<OrderInfo>,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if(isDarkModeEnabled == true){
//                Image(
//                    painter = painterResource(id = R.drawable.open),
//                    contentDescription = "Online"
//                )
//                Text("You are online.",fontSize = 28.sp)
//                Text("Waiting for new orders!", fontSize = 16.sp)
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(orders) { order ->
                        OrderInfoCard(order = order)
                    }
                }
            }else{
                Image(
                    painter = painterResource(id = R.drawable.offline),
                    contentDescription = "Offline"
                )
            }
        }
    }
}

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
                ),
                FoodItem(
                    name = "Food Item 4",
                    price = 300,
                    quantity = 2,
                    isVeg = false,
                    imageResId = R.drawable.dummy_food_image
                ),
                FoodItem(
                    name = "Food Item 5",
                    price = 300,
                    quantity = 2,
                    isVeg = false,
                    imageResId = R.drawable.dummy_food_image
                )
            ),
        )
    )

    ChefAppTheme {
        HomeContent(
            isDarkModeEnabled = true,
            orders = sampleOrders,
        )

    }
}
