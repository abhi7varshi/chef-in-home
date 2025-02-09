package com.example.userapp.features.reorderScreen

import android.R
import android.graphics.ColorFilter
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.userapp.composables.SearchTextField
import com.example.userapp.features.paymentScreen.components.OrderCard
import com.example.userapp.features.reorderScreen.components.ReOrderCard
import com.example.userapp.ui.theme.Green

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReOrderScreen() {
    var textValue by remember { mutableStateOf("") }
    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopAppBar(
                modifier = Modifier.statusBarsPadding(),
                title = {Text("Reorder")},
            )
        },
    ) {
        paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            // Search TextField
            SearchTextField(
                placeholder = "Search menu, restaurant or etc...",
                value = textValue,
                onValueChange = { textValue = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Button",
                        tint = Green,
                        modifier = Modifier.padding(horizontal = 3.dp)
                    )
                }
            )
            ReOrderCard()
        }
    }
}

@Preview
@Composable
fun ReOrderScreenPreview(){
    ReOrderScreen()
}