package com.example.userapp.features.support

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.userapp.composables.SearchTextField
import com.example.userapp.features.support.composables.SupportCard
import com.example.userapp.ui.theme.Green

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SupportScreen(modifier: Modifier = Modifier) {
    var textValue by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(title = {Text("Support Screen")})
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
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
            SupportCard()
        }
    }
}

@Preview
@Composable
fun SupportScreenPreview(){
    SupportScreen()
}