package com.example.userapp.navigation

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.userapp.PaymentScreenRoute
import com.example.userapp.R
import kotlinx.serialization.Serializable

//tab type
data class TopLevelRoute<T : Any>(
    val route: T,
    val title: String,
    val icon: ImageVector
)

//tabs
val TOP_LEVEL_ROUTES = listOf(
    TopLevelRoute(
        route = HomeRoute,
        title = "Home",
        icon = Icons.Default.Home
    ),
    TopLevelRoute(
        route = ReorderRoute,
        title = "Reorder",
        icon = Icons.Default.Refresh
    ),
    TopLevelRoute(
        route = SupportRoute,
        title = "Support",
        icon = Icons.Default.Email
    ),
    TopLevelRoute(
        route = AccountRoute,
        title = "Account",
        icon = Icons.Default.Person
    ),
)

//---------------------------------------------------------------------------------

//screens
@Serializable
data object HomeRoute

@Serializable
data object KitchenRoute

@Serializable
data object ReorderRoute

@Serializable
data object SupportRoute

@Serializable
data object AccountRoute

@Serializable
data object LoginRoute

@Serializable
data class OTPVerifyRoute(
    val phoneNumber: String
)

@Serializable
data object LocationRoute

@Serializable
data object AddressRoute

@Serializable
data object AccountScreenRoute