package com.example.userapp.features.paymentScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.userapp.features.paymentScreen.components.DiscountCard
import com.example.userapp.features.paymentScreen.components.OrderCard
import com.example.userapp.features.paymentScreen.components.PaymentButton
import com.example.userapp.features.paymentScreen.components.PaymentScreenLocationCard
import com.example.userapp.features.paymentScreen.components.PaymentScreenTopAppBar
import com.example.userapp.features.paymentScreen.components.TotalBillCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.statusBarsPadding(),
                title = { Text("Payment") },
                actions = {
                    PaymentScreenTopAppBar()
                }
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ){
            PaymentScreenLocationCard()
            OrderCard()
            DiscountCard()
            TotalBillCard()
            Spacer(modifier = Modifier.weight(1f))
            PaymentButton()
        }
    }
}

@Preview
@Composable
fun PaymentScreenPreview(){
    PaymentScreen()
}