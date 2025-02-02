package com.example.deliveryapp.dashBoard.Orders.Data

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class OrderViewModel : ViewModel() {
    private val _order= MutableStateFlow(Order(id = 0, name = "Sample_order", dishes = listOf()))
    val order: StateFlow<Order> = _order
}