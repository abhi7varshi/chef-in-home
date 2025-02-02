package com.example.deliveryapp.dashBoard.Orders.Data

import kotlinx.serialization.Serializable

@Serializable
data class Order(
    val id:Int,
    val name: String,
    val dishes: List<String>,
)

