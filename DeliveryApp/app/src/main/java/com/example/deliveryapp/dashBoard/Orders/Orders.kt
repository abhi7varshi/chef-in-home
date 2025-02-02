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
import com.example.deliveryapp.common_reusable_ui.CommonOrderBox


enum class DeliveryStatus {
    PickupPending,
    Delivered,
    pickupFailed,

}

@Composable
fun OrderScreen(
    modifier: Modifier
) {
    val expandedOrderId = remember { mutableStateOf<String?>(null) }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(top = 12.dp),
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

//
//                item {
//                    CommonOrderBox(
//                        orderId = "0115",
//                        status = "Pickup Pending",
//                        statusColor = Color.Blue
//                    )
//                }
//                item { Spacer(modifier = Modifier.height(12.dp)) }
//                item {
//                    CommonOrderBox(
//                        orderId = "0114",
//                        status = "Delivered",
//                        statusColor = Color.Green
//                    )
//                }
//                item { Spacer(modifier = Modifier.height(12.dp)) }
//                item {
//                    CommonOrderBox(
//                        orderId = "0113",
//                        status = "Delivered",
//                        statusColor = Color.Green
//                    )
//                }
//                item { Spacer(modifier = Modifier.height(12.dp)) }
//                item {
//                    CommonOrderBox(
//                        orderId = "0112",
//                        status = "pickup Failed",
//                        statusColor = Color.Red
//                    )
//                }
//                item { Spacer(modifier = Modifier.height(12.dp)) }
//                item {
//                    CommonOrderBox(
//                        orderId = "0111",
//                        status = "Delivered",
//                        statusColor = Color.Green
//                    )
//                }
//                item { Spacer(modifier = Modifier.height(12.dp)) }
//                item {
//                    CommonOrderBox(
//                        orderId = "0110",
//                        status = "Delivered",
//                        statusColor = Color.Green
//                    )
//                }
//                item { Spacer(modifier = Modifier.height(12.dp)) }
//                item {
//                    CommonOrderBox(
//                        orderId = "0109",
//                        status = "Delivered",
//                        statusColor = Color.Green
//                    )
//                }
//                item { Spacer(modifier = Modifier.height(12.dp)) }
//                item {
//                    CommonOrderBox(
//                        orderId = "0108",
//                        status = "Delivered",
//                        statusColor = Color.Green
//                    )
//                }
//                item { Spacer(modifier = Modifier.height(12.dp)) }
//                item {
//                    CommonOrderBox(
//                        orderId = "0107",
//                        status = "pickup Failed",
//                        statusColor = Color.Red
//                    )
//                }
//                item { Spacer(modifier = Modifier.height(12.dp)) }
//                item {
//                    CommonOrderBox(
//                        orderId = "0106",
//                        status = "Delivered",
//                        statusColor = Color.Green
//                    )
//                }
//                item { Spacer(modifier = Modifier.height(12.dp)) }
//                item {
//                    CommonOrderBox(
//                        orderId = "0105",
//                        status = "Delivered",
//                        statusColor = Color.Green
//                    )
//                }
//                item { Spacer(modifier = Modifier.height(12.dp)) }
//                item {
//                    CommonOrderBox(
//                        orderId = "0104",
//                        status = "Delivered",
//                        statusColor = Color.Green
//                    )
//                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun OrderScreenPreview() {
    OrderScreen(modifier = Modifier.padding(8.dp))
}