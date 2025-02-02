package com.example.userapp.features.homeScreen.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.userapp.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FoodTypesHomeScreenCircleGrid(text: String? = null) {
    Column(
        modifier = Modifier
            .padding(end = 16.dp, start = 10.dp)
    ) {
        if (text != null) {
            Text(
                text = text,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(horizontal = 5.dp, vertical = 12.dp)
            )
        }

        val foodItems = listOf(
            Pair("Idli", R.drawable.food_image_01),
            Pair("Dosa", R.drawable.food_image_02),
            Pair("Chitranna", R.drawable.food_image_03),
            Pair("Chole Bhature", R.drawable.food_image_04),
            Pair("Khichadi", R.drawable.food_image_05),
            Pair("Pani Puri", R.drawable.food_image_06),
            Pair("Gobi Manchurian", R.drawable.food_image_07),
            Pair("Momos", R.drawable.food_image_08),
            Pair("Thali", R.drawable.food_image_09),
            Pair("Paratha", R.drawable.food_image_10),
            Pair("Samosa", R.drawable.food_image_11),
            Pair("Biryani", R.drawable.food_image_12),
            Pair("Chicken", R.drawable.food_image_13),
            Pair("Mutton", R.drawable.food_image_14),
            Pair("Fish", R.drawable.food_image_15),
            Pair("Gulab Jamun", R.drawable.food_image_16),
        )

        val gridState = rememberLazyGridState()

        LazyHorizontalGrid(
            rows = GridCells.Fixed(2),
            state = gridState,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            items(foodItems) { item ->
                HomePageFoodsGridItem(
                    title = item.first,
                    iconId = item.second,
                    onCLick = {}
                )
            }
        }
    }
}
