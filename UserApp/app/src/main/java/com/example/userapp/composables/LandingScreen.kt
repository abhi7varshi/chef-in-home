package com.example.userapp.composables

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.userapp.features.account.AccountScreen
import com.example.userapp.features.homeScreen.HomeScreen
import com.example.userapp.features.paymentScreen.PaymentScreen
import com.example.userapp.features.reorderScreen.ReOrderScreen
import com.example.userapp.features.restaurantScreen.RestaurantScreen
import com.example.userapp.features.support.SupportScreen
import com.example.userapp.navigation.AccountRoute
import com.example.userapp.navigation.HomeRoute
import com.example.userapp.navigation.PaymentRoute
import com.example.userapp.navigation.ReorderRoute
import com.example.userapp.navigation.RestaurantRoute
import com.example.userapp.navigation.SupportRoute
import com.example.userapp.navigation.TOP_LEVEL_ROUTES

private const val TAG = "LandingScreen"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LandingScreen() {
    val navController = rememberNavController()

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    val bottomNavScreens = listOf(
        HomeRoute.javaClass.canonicalName,
        ReorderRoute.javaClass.canonicalName,
        SupportRoute.javaClass.canonicalName,
        AccountRoute.javaClass.canonicalName
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            // show bottom bar only for top level routes
            if (currentRoute in bottomNavScreens) {
                MyBottomNavigation(navController = navController)
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            //for navigation after otp
            NavHost(navController = navController, startDestination = HomeRoute) {
                composable<HomeRoute> {
                    HomeScreen(navController = navController)
                }

                composable<RestaurantRoute> {
                    RestaurantScreen(navController = navController)
                }

                composable<PaymentRoute> {
                    PaymentScreen(navController = navController)
                }

                composable<ReorderRoute> {
                    ReOrderScreen()
                }

                composable<SupportRoute> {
                    SupportScreen()
                }

                composable<AccountRoute> {
                    AccountScreen()
                }
            }
        }
    }
}

@Composable
fun MyBottomNavigation(navController: NavHostController) {
    val selectedIndex = rememberSaveable { mutableIntStateOf(0) }

    NavigationBar {
        TOP_LEVEL_ROUTES.forEachIndexed { index, destination ->
            NavigationBarItem(
                selected = index == selectedIndex.intValue,
                onClick = {
                    selectedIndex.intValue = index

                    //navigation
                    navController.navigate(TOP_LEVEL_ROUTES[index].route) {
                        popUpTo(HomeRoute)
                        launchSingleTop = true
                    }
                },
                label = { Text(destination.title) },
                icon = { Icon(imageVector = destination.icon, contentDescription = null) }
            )
        }
    }
}
