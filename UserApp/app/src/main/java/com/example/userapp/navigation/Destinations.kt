package com.example.userapp.navigation

import com.example.userapp.R
import kotlinx.serialization.Serializable

//tab type
data class TopLevelRoute<T : Any>(
    val route: T,
    val title: String,
    val iconRes: Int,
    val selectedIconRes: Int
)

//tabs
val TOP_LEVEL_ROUTES = listOf(
    TopLevelRoute(
        route = HomeRoute,
        title = "Home",
        iconRes = R.drawable.home_icon,
        selectedIconRes = R.drawable.home_selected_icon
    ),
    TopLevelRoute(
        route = ReorderRoute,
        title = "Reorder",
        iconRes = R.drawable.reorder_icon,
        selectedIconRes = R.drawable.reorder_selected_icon
    ),
    TopLevelRoute(
        route = SupportRoute,
        title = "Support",
        iconRes = R.drawable.support_icon,
        selectedIconRes = R.drawable.support_selected_icon
    ),
    TopLevelRoute(
        route = AccountRoute,
        title = "Account",
        iconRes = R.drawable.account_icon,
        selectedIconRes = R.drawable.reorder_selected_icon
    ),
)

//---------------------------------------------------------------------------------

//screens
@Serializable
data object HomeRoute

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


