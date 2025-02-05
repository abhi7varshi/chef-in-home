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
import com.example.userapp.composables.AppMainSearchTextField
import com.example.userapp.features.homeScreen.components.FoodTypesHomeScreenCircleGrid
import com.example.userapp.features.homeScreen.components.MultipleHomeScreenRestroCards
import com.example.userapp.features.homeScreen.components.ScrollableCards
import com.example.userapp.features.homeScreen.components.TopAppBarComposable
import androidx.compose.ui.graphics.Color as ComposeColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.statusBarsPadding(),
                title = { Text("Home") },
                actions = {
                    TopAppBarComposable()
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
                .background(ComposeColor.White)
                .padding(paddingValues)
        ) {
            AppMainSearchTextField()
            ScrollableCards()
            FoodTypesHomeScreenCircleGrid("What’s mom cooking for you today?")
            MultipleHomeScreenRestroCards(noOfRestaurantsAround = 123)
        }
    }
}
