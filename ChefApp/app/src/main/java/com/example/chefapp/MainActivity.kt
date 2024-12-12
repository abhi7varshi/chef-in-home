@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.chefapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.chefapp.ui.theme.ChefAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChefAppTheme {
                HomeScreen()
            }
        }
    }
}


@Composable
fun HomeScreen() {
    Scaffold(topBar = {
        TopAppBar(title = { Text("Home Screen") })
    }) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = Color.Red)
            ,
            contentAlignment = Alignment.Center
        ) {
            Text("Lauda, Mera!🍆🍑")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ChefAppTheme {
        HomeScreen()
    }
}