package com.example.chefapp.ui.composable

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chefapp.R
import com.example.chefapp.data.FoodItem
import com.example.chefapp.data.OrderInfo
import com.example.chefapp.data.calculateTotalBill
import com.example.chefapp.ui.theme.PrimaryColor

@Composable
fun OrderInfoCard(order: OrderInfo) {
    val context = LocalContext.current
    val totalBill = order.calculateTotalBill()

    OutlinedCard(
        colors = androidx.compose.material3.CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp) 
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            // Order ID and Time
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "ID: ${order.id}", textAlign = TextAlign.Start)
                Text(text = order.time, textAlign = TextAlign.End)
            }

            HorizontalDivider(
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Items List
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                order.items.forEach { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Food Image
                        Image(
                            painter = painterResource(id = item.imageResId),
                            contentDescription = item.name,
                            modifier = Modifier.size(55.dp)
                        )

                        // Food Name and Veg/Non-Veg Icon
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 8.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                // Food Name
                                Text(text = item.name)
                                Spacer(modifier = Modifier.width(4.dp))
                                //veg or non-veg icon
                                Image(
                                    painter = painterResource(
                                        id = if (item.isVeg) R.drawable.veg_icon else R.drawable.non_veg_icon
                                    ),
                                    contentDescription = if (item.isVeg) "Veg" else "Non-Veg",
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                            // Quantity
                            Text(text = "Quantity: ${item.quantity}")
                        }

                        // Price
                        Text(text = "₹${item.price * item.quantity}")
                    }
                }
            }

            HorizontalDivider(
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Total Bill Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Total Bill", textAlign = TextAlign.Start)

                Text(text = "₹$totalBill", textAlign = TextAlign.End)
            }

            HorizontalDivider(
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Buttons Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                OutlinedButton(
                    onClick = {
                    /* Handle Reject */
                        Toast.makeText(context, "Order Rejected ❌", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.Red
                    )
                ) {
                    Text("Reject")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = {
                        /* Handle Reject */
                        Toast.makeText(context, "Order Accepted! ✅", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PrimaryColor,
                    )
                ) {
                    Text("Accept")
                }
            }
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
        )
    )
}