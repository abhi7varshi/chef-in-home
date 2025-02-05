package com.example.userapp.features.restaurantScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.userapp.R

@Composable
fun RestaurantScreenInfoSection(
//    restaurantName: String,
//    restaurantType: String,
//    restaurantLocation: String,
//    deliveryDistanceInKms: Int,
//    isMultipleLocations: Boolean = false,
//    deliveryTimeInMins: Int,
//    ratingText: Float?,
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start

            ) {
                //Restaurant Name
                Text(
//                    text = restaurantName,
                    text = "Annapurna Kitchen",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 24.sp
                )
                //Restaurant Type
                Text(
//                    text = restaurantType,
                    text = "Idly, Samosa, Dosa",
                    fontWeight = FontWeight.SemiBold,
                    color = Color.DarkGray,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top = 5.dp, bottom = 2.dp)
                )
                //Restaurant Location
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
//                        text = "$restaurantLocation • ",
                        text = "",
                        fontSize = 13.sp,
                        color = Color.DarkGray,
                        modifier = Modifier.padding(end = 3.dp)
                    )
                    Text(
//                        text = "$deliveryDistanceInKms km",
                        text = "This Distance",
                        fontSize = 12.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
//                    if (isMultipleLocations) {
//                        Icon(
//                            Icons.Default.ArrowDropDown,
//                            contentDescription = "Arrow Drop Down",
//                            tint = Color.Red
//                        )
//                    }
                }
                //Restaurant Safety Details
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.max_safety_delivery_png),
                        contentDescription = "Max Safety Image",
                        modifier = Modifier.size(45.dp)
                    )
                    Text(
                        text = "know more",
                        fontSize = 13.sp,
                        color = Color.DarkGray,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(horizontal = 4.dp)
                    )
                }
                //Delivery Time
                Card(
                    shape = RoundedCornerShape(6.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFECECEC),
                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(3.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_timer_24),
                            contentDescription = "",
                            tint = Color(0xFF489547)
                        )
                        Text(
//                            text = " $deliveryTimeInMins mins",
                            text = "Delevery Time",
                            color = Color.DarkGray,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(horizontal = 1.dp)
                        )
                    }
                }
            }
            //Rating Card
            Card(
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF489547),
                )
            ) {
                Column {
                    //Rating
                    Box {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .padding(vertical = 8.dp, horizontal = 10.dp)
                        ) {
                            Text(
//                                text = "$ratingText",
                                text = "5",
                                fontSize = 18.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Icon(
                                Icons.Default.Star,
                                contentDescription = "Rating Star",
                                tint = Color.White,
                                modifier = Modifier.size(15.dp)
                            )
                        }
                    }
                    //Number of Ratings
                    Box(
                        modifier = Modifier
                            .background(Color.White)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(vertical = 4.dp, horizontal = 8.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "11.9k",
                                fontSize = 14.sp,
                                color = Color.DarkGray,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = "Reviews",
                                fontSize = 13.sp,
                                color = Color.DarkGray,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }
        }
    }
}
