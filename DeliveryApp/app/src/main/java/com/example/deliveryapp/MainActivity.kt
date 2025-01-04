@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.deliveryapp

import SettingsRepository
import SettingsViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.deliveryapp.common_reusable_ui.BottomNavigationBar
import com.example.deliveryapp.dashBoard.AccountScreen
import com.example.deliveryapp.dashBoard.Orders.DeliveryScreen
import com.example.deliveryapp.dashBoard.Orders.OrderScreen
import com.example.deliveryapp.ui.theme.DeliveryAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DeliveryAppTheme {
//                PersonalInfo()
//                HomeScreen()
                DeliveryScreen(modifier = Modifier)
//                UploadDocument(text = "Driving License")
//                RegistrationDone()
//                PersonalDocument()

            }
        }
    }
}


@Composable
fun customBottomNavigation() {

}

@Composable
fun HomeScreen() {
    val repo = SettingsRepository(context = LocalContext.current)
    val viewModel = SettingsViewModel(repository = repo)
    var selectedTab = remember { mutableStateOf("Orders") }
    val isDarkModeEnabled = viewModel.darkModeEnabled.collectAsState(initial = false)

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                if (selectedTab.value == "Orders") Row {
                    Icon(
                        imageVector = Icons.Outlined.ShoppingCart,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Orders",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W600)
                    )
                }
                else Row {
                    Icon(
                        imageVector = Icons.Outlined.AccountCircle,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Accounts",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W600)
                    )
                }
            },
            colors = TopAppBarColors(
                containerColor = Color.White,
                scrolledContainerColor = Color.Transparent,
                navigationIconContentColor = Color.Transparent,
                titleContentColor = MaterialTheme.colorScheme.onSurface,
                actionIconContentColor = Color.Transparent
            ),
        )
    },
        bottomBar = {
            BottomNavigationBar(selectedTab)
        }
    ) { innerPadding ->
        if (selectedTab.value == "Account") {
            AccountScreen(modifier = Modifier.padding(innerPadding))
        } else {
//            DeliveryScreen(modifier = Modifier.padding(innerPadding))
            OrderScreen(modifier = Modifier.padding(innerPadding))
//            Box(
//                modifier = Modifier
//                    .padding(innerPadding)
//                    .fillMaxSize()
//                    .background(color = MaterialTheme.colorScheme.background),
//                contentAlignment = Alignment.Center
//            ) {
//                Column {
//
//                    Text("Dark mode: ${isDarkModeEnabled.value}")
//                    Switch(checked = isDarkModeEnabled.value, onCheckedChange = {
//                        viewModel.setDarkMode(it)
//                    })
//                }
//            }
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