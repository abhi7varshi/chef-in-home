@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.deliveryapp

import SettingsRepository
import SettingsViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.deliveryapp.ui.theme.DeliveryAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DeliveryAppTheme {
                HomeScreen()
            }
        }
    }
}


@Composable
fun HomeScreen() {
    val repo = SettingsRepository(context = LocalContext.current)
    val viewModel = SettingsViewModel(repository = repo)

    val isDarkModeEnabled = viewModel.darkModeEnabled.collectAsState(initial = false)

    Scaffold(topBar = {
        TopAppBar(title = { Text("Saurabh Home Screen") })
    }) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Text("Dark mode: ${isDarkModeEnabled.value}")
                Switch(checked = isDarkModeEnabled.value, onCheckedChange = {
                    viewModel.setDarkMode(it)
                })
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DeliveryAppTheme {
        HomeScreen()
    }
}