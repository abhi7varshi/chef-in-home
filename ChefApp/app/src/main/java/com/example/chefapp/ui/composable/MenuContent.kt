package com.example.chefapp.ui.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.chefapp.AddDishRoute
import com.example.chefapp.R
import com.example.chefapp.data.FoodItem
import com.example.chefapp.data.OrderInfo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuContent(
    orders: List<OrderInfo>,
    navController: NavController
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

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(orders) { order ->
                        MenuInfoCard(navController)
                    }
                }
        }
        FloatingActionButton(
            onClick = {
                navController.navigate(route = AddDishRoute)
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Order"
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MenuContentPreview() {
    MenuContent(
        orders = listOf(
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
        ),
        navController = NavController(LocalContext.current)
    )
}