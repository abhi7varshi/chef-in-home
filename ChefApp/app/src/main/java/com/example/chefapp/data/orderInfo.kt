package com.example.chefapp.data

data class OrderInfo(
    val id: String,
    val time: String,
    val items: List<Pair<String, Int>>, // List of {Food Item Name, Price}
    val totalBill: Int
)

val dummyOrders = listOf(
    OrderInfo(
        id = "4002",
        time = "8:00 PM",
        items = listOf("Food Item 1" to 200, "Food Item 2" to 300),
        totalBill = 500
    ),
    OrderInfo(
        id = "4003",
        time = "9:00 PM",
        items = listOf("Food Item 3" to 150, "Food Item 4" to 250),
        totalBill = 400
    )
)