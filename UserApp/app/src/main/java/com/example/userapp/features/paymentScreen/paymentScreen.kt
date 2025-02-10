package com.example.userapp.features.paymentScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.userapp.features.paymentScreen.components.DiscountCard
import com.example.userapp.features.paymentScreen.components.OrderCard
import com.example.userapp.features.paymentScreen.components.PaymentButton
import com.example.userapp.features.paymentScreen.components.PaymentScreenLocationCard
import com.example.userapp.features.paymentScreen.components.PaymentScreenTopAppBar
import com.example.userapp.features.paymentScreen.components.TotalBillCard
import com.example.userapp.features.reorderScreen.ReOrderScreen
import com.example.userapp.navigation.ReorderRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.statusBarsPadding(),
                title = { Text("Annapurna Kitchen") },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
                }
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            PaymentScreenLocationCard()
            OrderCard()
            DiscountCard()
            TotalBillCard()
            Spacer(modifier = Modifier.weight(1f))
            PaymentButton(onClick = {
                navController.navigate(route = ReorderRoute)
            })
        }
    }
}

@Preview
@Composable
fun PaymentScreenPreview() {
    PaymentScreen()
}