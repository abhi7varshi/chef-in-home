package com.example.userapp.features.restaurantScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.userapp.features.restaurantScreen.components.DropDownList
import com.example.userapp.features.restaurantScreen.components.RestaurantScreenCategoryDropDown
import com.example.userapp.features.restaurantScreen.components.RestaurantScreenInfoSection
import com.example.userapp.features.restaurantScreen.components.RestaurantScreenOfferScrollableRow
import com.example.userapp.features.restaurantScreen.components.RestaurantScreenTopAppBar
import com.example.userapp.features.restaurantScreen.components.SwitchButtonsRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantScreen(
    //    offerPercentageText: Int?,
    //    offerUpToText: Int?,
    //    restaurantName: String,
    //    restaurantType: String,
    //    restaurantLocation: String,
    //    deliveryDistanceInKms: Int,
    //    isMultipleLocations: Boolean = false,
    //    deliveryTimeInMins: Int,
    //    isPureVegetarian: Boolean = false,
    //    ratingText: Float?
){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.statusBarsPadding(),
                title = { Text("Restaurant") },
                actions = {
                    RestaurantScreenTopAppBar()
                }
            )
        },
        bottomBar = {
            // Add your BottomNavigationBar here
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .verticalScroll(state = rememberScrollState())
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            RestaurantScreenInfoSection(
//                restaurantName,
//                restaurantType,
//                restaurantLocation,
//                deliveryDistanceInKms,
//                isMultipleLocations,
//                deliveryTimeInMins,
//                ratingText
            )
            RestaurantScreenOfferScrollableRow()
            SwitchButtonsRow(
//                isPureVegetarian
            )
            RestaurantScreenCategoryDropDown({ DropDownList() }, "Recommended", 18)
            RestaurantScreenCategoryDropDown({ DropDownList() }, "Combos", 9)
            RestaurantScreenCategoryDropDown({ DropDownList() }, "Meals", 10)
            RestaurantScreenCategoryDropDown({ DropDownList() }, "Main Course", 51)
            RestaurantScreenCategoryDropDown({ DropDownList() }, "Starters", 14)
        }
    }
}