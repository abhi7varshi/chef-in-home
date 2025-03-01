package com.example.userapp.features.homeScreen.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.userapp.R
import com.example.userapp.ui.theme.BlueColor
import com.example.userapp.ui.theme.Green

@Composable
fun RestaurantImageNameCardBig(
    @DrawableRes image: Int,
    offerPercentageText: Int?,
    offerUpToText: Int?,
    deliveryTimeInMins: Int,
    deliveryDistanceInKms: Int,
    ratingText: Float?,
    restaurantName: String,
    restaurantType: String,
    closingSoonTimeInMins: Int?,
    costForTwoInINR: Int,
    isPureVegetarian: Boolean = false,
    isPromoted: Boolean = false,
    isClosesSoon: Boolean = false,
    isRecycleFriendly: Boolean = false,
//    navigator: DestinationsNavigator
    onClick: () -> Unit = {},
) {
    Card(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(LocalConfiguration.current.screenWidthDp.dp)
            .padding(vertical = 6.dp, horizontal = 16.dp),
//        onClick = {
//            navigator.navigate(
//                RestaurantScreenDestination(
//                    offerPercentageText,
//                    offerUpToText,
//                    restaurantName,
//                    restaurantType,
//                    "Chandigarh",
//                    deliveryDistanceInKms,
//                    isMultipleLocations = true,
//                    deliveryTimeInMins,
//                    isPureVegetarian,
//                    ratingText
//                )
//            )
//        }
    ) {
        Column {
            ImageBigCard(
                image = image,
                offerPercentageText = offerPercentageText,
                offerUpToText = offerUpToText,
                deliveryTimeInMins = deliveryTimeInMins,
                deliveryDistanceInKms = deliveryDistanceInKms,
                isPureVegetarian = isPureVegetarian,
                isPromoted = isPromoted
            )
            ContentBigCard(
                ratingText = ratingText,
                restaurantName = restaurantName,
                restaurantType = restaurantType,
                closingSoonTimeInMins = closingSoonTimeInMins,
                costForTwoInINR = costForTwoInINR,
                isClosesSoon = isClosesSoon,
                isRecycleFriendly = isRecycleFriendly
            )
        }
    }
}

@Composable
fun ImageBigCard(
    @DrawableRes image: Int,
    offerPercentageText: Int?,
    offerUpToText: Int?,
    deliveryTimeInMins: Int,
    deliveryDistanceInKms: Int,
    isPureVegetarian: Boolean = false,
    isPromoted: Boolean = false
) {
    var isFavourite by remember {
        mutableStateOf(false)
    }


    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .height((LocalConfiguration.current.screenWidthDp / 1.8).dp)
            .fillMaxWidth()
            .background(Color.DarkGray)
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "Restaurant Image",
            contentScale = ContentScale.FillBounds
        )

        Column {
            if (isPureVegetarian) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Green),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.leaf_vector),
                        contentDescription = "R.string.pure_veg_restaurant",
                        tint = Color.White,
                        modifier = Modifier.size(15.dp)
                    )
                    Text(
                        text = "Pure Veg Restaurant",
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 10.sp,
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
            Column(
                modifier = Modifier.height((LocalConfiguration.current.screenWidthDp / 1.5).dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .alpha(0.6f)
                            .background(
                                if (isPromoted) {
                                    Color.Black
                                } else {
                                    Color.Transparent
                                }
                            )
                    ) {
                        Text(
                            text = "Promoted",
                            fontSize = 10.sp,
                            modifier = Modifier
                                .alpha(0.8f)
                                .padding(vertical = 1.dp, horizontal = 3.dp),
                            color = if (isPromoted) {
                                Color.White
                            } else {
                                Color.Transparent
                            }
                        )
                    }
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color.White)
                            .clickable { isFavourite = !isFavourite },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(
                                if (isFavourite) {
                                    R.drawable.favorite_filled
                                } else {
                                    R.drawable.favourite_border
                                }
                            ),
                            contentDescription = "R.string.like_button_text",
                            tint = Color.Red,
                            modifier = Modifier.padding(5.dp)
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .padding(end = 10.dp, bottom = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Card(
                        shape = RoundedCornerShape(topEnd = 6.dp, bottomEnd = 6.dp),
                        colors = CardDefaults.cardColors(containerColor = BlueColor)
                    ) {
                        Row(
                            modifier = Modifier.padding(vertical = 3.dp, horizontal = 7.dp),
                            verticalAlignment = Alignment.Top,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.percentage_vector),
                                contentDescription = "Offer Percentage",
                                tint = Color.White,
                                modifier = Modifier
                                    .size(15.dp)
                            )
                            Column {
                                Text(
                                    text = "${offerPercentageText.toString()}% OFF",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier.padding(start = 2.dp)
                                )
                                Text(
                                    text = "Up to ₹${offerUpToText.toString()}",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier.padding(start = 2.dp)
                                )
                            }
                        }
                    }
                    Card(
                        shape = RoundedCornerShape(6.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White,
                        ),
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(vertical = 3.dp, horizontal = 4.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_timer_24),
                                contentDescription = "",
                                tint = Green
                            )
                            Text(
                                text = " $deliveryTimeInMins mins | $deliveryDistanceInKms km",
                                color = Color.DarkGray,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.padding(start = 1.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun ContentBigCard(
    ratingText: Float?,
    restaurantName: String,
    restaurantType: String,
    closingSoonTimeInMins: Int?,
    costForTwoInINR: Int,
    isClosesSoon: Boolean = false,
    isRecycleFriendly: Boolean = false
) {
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = restaurantName,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 18.sp
                )
                Text(
                    text = restaurantType,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.DarkGray,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(vertical = 3.dp)
                )
                if (isClosesSoon) {
                    Text(
                        text = "Closes in $closingSoonTimeInMins Mins",
                        color = Color.Red,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(Green)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(vertical = 3.dp, horizontal = 5.dp)
                    ) {
                        Text(
                            text = ratingText.toString(),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                                .padding(end = 1.dp),
                            color = Color.White
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.star_filled),
                            contentDescription = "Rating",
                            tint = Color.White,
                            modifier = Modifier
                                .size(14.dp)
                        )
                    }
                }
                Text(
                    text = "₹$costForTwoInINR for two",
                    fontWeight = FontWeight.SemiBold,
                    color = Color.DarkGray,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
        if (isRecycleFriendly) {
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp),
                color = Color.LightGray,
                thickness = 0.5.dp
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.recycle_png),
                    contentDescription = "Recycle Image",
                    tint = Green,
                    modifier = Modifier.size(15.dp)
                )
                Text(
                    modifier = Modifier.padding(3.dp),
                    text = "We recycle more plastic than used in orders",
                    fontSize = 10.sp,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}
