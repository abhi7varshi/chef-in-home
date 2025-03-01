package com.example.userapp.features.homeScreen

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.userapp.composables.AppMainSearchTextField
import com.example.userapp.features.homeScreen.components.FoodTypesHomeScreenCircleGrid
import com.example.userapp.features.homeScreen.components.MultipleHomeScreenRestroCards
import com.example.userapp.features.homeScreen.components.ScrollableCards
import com.example.userapp.features.homeScreen.components.TopAppBarComposable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .verticalScroll(state = rememberScrollState())
                .fillMaxSize()
                .background(White)
                .padding(paddingValues)
        ) {
            TopAppBarComposable()
            AppMainSearchTextField()
            ScrollableCards()
            FoodTypesHomeScreenCircleGrid("What’s mom cooking for you today?")
            MultipleHomeScreenRestroCards(
                noOfRestaurantsAround = 123,
                navController = navController
            )
        }
    }
}

