package com.example.userapp.features.reorderScreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.userapp.ui.theme.Green
import com.example.userapp.R


@Composable
fun ReOrderCard() {
    val quantity = remember { mutableIntStateOf(1) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
        ) {
            // Restaurant Name
            Text(
                text = "Annapurna Kitchen",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Order Placed Time
            Text(
                text = "Order placed on 16 Jan, 3:21 PM",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Rating and Delivery Info
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Star Icon",
                    tint = Green,
                    modifier = Modifier.size(14.dp)
                )

                Text(
                    text = "4.2",
                    fontSize = 14.sp,
                    color = Green
                )

                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Location Icon",
                    tint = Green,
                    modifier = Modifier.size(18.dp)
                )

                // Delivery Info
                Text(
                    text = "HSR Layout",
                    fontSize = 14.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.width(8.dp))

                Image(
                    painter = painterResource(R.drawable.clock),
                    contentDescription = "Clock icon",
                    colorFilter = ColorFilter.tint(Green),
                    modifier = Modifier.size(18.dp)
                )

                // Delivery Info
                Text(
                    text = "15-20 min",
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Divider(
                color = Color.Gray,
                thickness = 0.5.dp,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                // Text Column
                Column(
                    modifier = Modifier.weight(1f), // Take remaining space
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.veg_icon),
                        contentDescription = "veg/non-veg",
                        modifier = Modifier
                            .size(30.dp)
                            .padding(end = 12.dp)
                    )

                    Spacer(modifier = Modifier.padding(4.dp))

                    Text(
                        text = "Special Idly",
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.padding(4.dp))

                    Text(
                        text = "₹89",
                        textAlign = TextAlign.Start,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }

                // Quantity Counter
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .border(
                            border = BorderStroke(width = 1.dp,Green),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White)
                        .padding(horizontal = 8.dp, vertical = 8.dp)
                ) {
                    // Minus Button
                    Text(
                        text = "-",
                        color = Green,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .clickable {
                                if (quantity.value > 1) quantity.value-- // Decrement quantity
                            }
                            .clip(CircleShape)
                            .size(24.dp)
                            .wrapContentSize(Alignment.Center)
                    )

                    Spacer(Modifier.width(8.dp))

                    // Quantity Display
                    Text(
                        text = "${quantity.value}", // Access the value of quantity
                        fontSize = 16.sp,
                        color = Green,
                        modifier = Modifier.width(20.dp),
                        textAlign = TextAlign.Center
                    )

                    Spacer(Modifier.width(8.dp))

                    // Plus Button
                    Text(
                        text = "+",
                        color = Green,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .clickable {
                                quantity.value++ // Increment quantity
                            }
                            .clip(CircleShape)
                            .size(24.dp)
                            .wrapContentSize(Alignment.Center)
                    )
                }
            }

            // Add Button
            Button(
                onClick = { /* Handle button click */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4CAF50),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "+ ADD",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview
@Composable
fun ReOrderCardPreview() {
    ReOrderCard()
}
