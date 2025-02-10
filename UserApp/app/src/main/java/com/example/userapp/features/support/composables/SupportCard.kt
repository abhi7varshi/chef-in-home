package com.example.userapp.features.support.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.userapp.R
import com.example.userapp.ui.theme.Green

@Composable
fun SupportCard() {
    var currentRating by remember { mutableStateOf(0) }
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

                // Food Image
                Image(
                    painter = painterResource(R.drawable.food_image_01),
                    contentDescription = "Food Image",
                    modifier = Modifier
                        .size(64.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
            }

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Enjoyed food?",
                    fontSize = 18.sp,
                )
            }

            // Rating
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                // Background with shadow
                Box(
                    modifier = Modifier
                        .shadow(
                            elevation = 20.dp,
                            shape = RoundedCornerShape(
                                topStart = 0.dp,
                                topEnd = 0.dp,
                                bottomStart = 8.dp,
                                bottomEnd = 8.dp
                            ),
                            spotColor = Color.Black.copy(alpha = 0.02f),
                            ambientColor = Color.Black.copy(alpha = 0.02f),
                        )
                        .clip(
                            RoundedCornerShape(
                                topStart = 0.dp,
                                topEnd = 0.dp,
                                bottomStart = 8.dp,
                                bottomEnd = 8.dp
                            )
                        )
//                        .background(Color(0xFFF8F8F8))
                        .fillMaxWidth()
                        .height(80.dp)
                ) {
                    // Stars row
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        for (i in 1..5) {
                            RatingStar(
                                index = i,
                                currentRating = currentRating,
                                onRatingSelected = { selected ->
                                    currentRating = selected
                                }
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.padding(4.dp))

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Submit",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun RatingStar(
    index: Int,
    currentRating: Int,
    onRatingSelected: (Int) -> Unit,
    starSize: Dp = 48.dp
) {
    IconButton(
        onClick = { onRatingSelected(index) },
        modifier = Modifier.size(starSize)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(
                id = if (index <= currentRating) R.drawable.ic_star_filled
                else R.drawable.ic_star_outline
            ),
            contentDescription = "Star $index",
            tint = if (index <= currentRating) Color(0xFFFFD700)
            else Color(0xFFA0A0A0),
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
fun SupportCardPreview() {
    SupportCard()
}