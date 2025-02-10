package com.example.userapp.features.restaurantScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.userapp.features.restaurantScreen.components.DropDownList
import com.example.userapp.features.restaurantScreen.components.RestaurantScreenCategoryDropDown
import com.example.userapp.features.restaurantScreen.components.RestaurantScreenInfoSection
import com.example.userapp.features.restaurantScreen.components.RestaurantScreenOfferScrollableRow
import com.example.userapp.features.restaurantScreen.components.RestaurantScreenTopAppBar
import com.example.userapp.features.restaurantScreen.components.SwitchButtonsRow
import com.example.userapp.navigation.PaymentRoute

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
    //    ratingText: Float?,
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = {}, navigationIcon = {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = null
                    )
                }
            })
        },
        bottomBar = {
            // Add your BottomNavigationBar here
        },
        floatingActionButton = {
            Box(contentAlignment = Alignment.TopEnd) {
                FloatingActionButton(onClick = {
                    navController.navigate(route = PaymentRoute)
                }) {
                    Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null)
                }
                Badge {
                    Text(text = "3", modifier = Modifier.padding(2.dp))
                }
            }
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