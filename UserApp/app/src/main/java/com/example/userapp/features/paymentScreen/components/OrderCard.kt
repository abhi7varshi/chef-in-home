package com.example.userapp.features.paymentScreen.components

import android.view.RoundedCorner
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.userapp.R
import com.example.userapp.ui.theme.Green

@Composable
fun OrderCard() {
    // Use mutableIntStateOf for better performance with integer states
    val quantity = remember { mutableIntStateOf(1) }

    ElevatedCard(
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
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

        Spacer(modifier = Modifier.padding(4.dp))

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = " + Add more items",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
fun OrderCardPreview() {
    OrderCard()
}