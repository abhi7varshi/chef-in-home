package com.example.chefapp.ui.composable

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.chefapp.ui.viewModel.AuthViewModel
import com.example.chefapp.R
import com.example.chefapp.SettingsRepository
import com.example.chefapp.SettingsViewModel
import com.example.chefapp.data.dummyOrders
import com.example.chefapp.ui.theme.PrimaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
) {
    val selectedIndex = remember { mutableIntStateOf(0) }

    val repo = SettingsRepository(context = LocalContext.current)
    val viewModel = SettingsViewModel(repository = repo)

    val isDarkModeEnabled = viewModel.darkModeEnabled.collectAsState(initial = false)

    // Dynamic title based on selected tab
    val titles = listOf("Orders", "Menu", "Settings")

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = PrimaryColor,
                ),
                title = {
                    Text(
                        titles[selectedIndex.intValue], // Use the dynamic title here
                        color = Color.White
                    )
                },
                actions = {
                    // Show Online text and Switch only on the Orders tab
                    if (selectedIndex.intValue == 0) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(end = 16.dp)
                        ) {
                            Text(
                                "Online",
                                fontSize = 16.sp,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Switch(
                                checked = isDarkModeEnabled.value,
                                onCheckedChange = { isChecked ->
                                    viewModel.setDarkMode(isChecked)
                                    Log.d("HomeScreen", "Online Switch Toggled")
                                    Log.d("HomeScreen", "Dark mode updated: $isChecked")
                                },
                                modifier = Modifier.scale(0.8f),
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = Color(0xFF4CAF50),
                                    checkedTrackColor = Color(0xFF81C784)
                                )
                            )
                        }
                    }
                },
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedIndex.intValue == 0,
                    onClick = { selectedIndex.intValue = 0 },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.tray),
                            contentDescription = "Orders - Tray Icon",
                            modifier = Modifier.size(25.dp)
                        )
                    },
                    label = { Text("Orders") },

                )
                NavigationBarItem(
                    selected = selectedIndex.intValue == 1,
                    onClick = { selectedIndex.intValue = 1 },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.menu),
                            contentDescription = "Menu Icon",
                            modifier = Modifier.size(25.dp)
                        )
                    },
                    label = { Text("Menu") }
                )
                NavigationBarItem(
                    selected = selectedIndex.intValue == 2,
                    onClick = { selectedIndex.intValue = 2 },
                    icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") },
                    label = { Text("Settings") }
                )
            }
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
        ) {
            when (selectedIndex.intValue) {
                0 -> HomeContent(orders = dummyOrders, isDarkModeEnabled = isDarkModeEnabled.value)
                1 -> MenuContent(orders = dummyOrders, navController = navController)
                2 -> SettingsContent(navController = navController, authViewModel = viewModel())
            }
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}
