package com.example.deliveryapp.dashBoard.Orders

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.deliveryapp.common_reusable_ui.CommonOrderBox


enum class DeliveryStatus {
    PickupPending,
    Delivered,
    pickupFailed,

}

@Composable
fun OrderScreen(
    navController: NavController
) {
    val expandedOrderId = remember { mutableStateOf<String?>(null) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(top = 120.dp),
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(horizontalArrangement = Arrangement.Center) {
                Text(
                    text = "Tap to Expand",
                    style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.secondary)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            LazyColumn(
                verticalArrangement = Arrangement.Top,
            ) {
                val orders = listOf(
                    "0115" to "pickup pending",
                    "0114" to "Delivered",
                    "0113" to "Delivered",
                    "0112" to "Pickup Failed",
                    "0111" to "Delivered",
                    "0110" to "Delivered",
                    "0109" to "Delivered",
                    "0108" to "Delivered",
                    "0107" to "pickup Failed",
                    "0106" to "Delivered",
                    "0105" to "Delivered",
                    "0104" to "Delivered"
                    )

                orders.forEach{ (orderId, status)->
                    item {
                        CommonOrderBox(
                            navController = navController,
                            orderId = orderId,
                            status = status,
                            statusColor = when(status){
                                "Pickup pending" -> Color.Blue
                                "Delivered" -> Color.Green
                                "Pickup Failed" -> Color.Red
                                else -> Color.Gray
                            },
                            isExpanded = expandedOrderId.value == orderId,
                            onSingleTap = {
                                print("presses single tap")
                                expandedOrderId.value = if (expandedOrderId.value == orderId) null else orderId
                            },
                            onDoubleTap = {
                                print("presses double tap")
                                expandedOrderId.value=null
                            }
                        )
                        Spacer(modifier = Modifier.height(14.dp))
                    }
                }

            }
        }
    }
}

