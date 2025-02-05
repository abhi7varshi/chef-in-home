package com.example.userapp.features.restaurantScreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.userapp.ui.theme.zLightGreyBorder

@Composable
fun RestaurantScreenTopAppBar() {
    val iconPadding: Dp = 5.dp
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Icon(Icons.Default.ArrowBack, contentDescription = "Back Arrow", tint = Color.Black)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
                border = BorderStroke(0.5.dp, zLightGreyBorder),
                shape = CircleShape
            ) {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = Color.Black,
                    modifier = Modifier.padding(iconPadding)
                )
            }
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
                border = BorderStroke(0.5.dp, zLightGreyBorder),
                shape = CircleShape,
                modifier = Modifier.padding(start = 6.dp)
            ) {
                Icon(
                    Icons.Default.MoreVert,
                    contentDescription = "Three Dots Icon",
                    tint = Color.Black,
                    modifier = Modifier.padding(iconPadding)
                )
            }
        }
    }
}
