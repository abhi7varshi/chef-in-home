package com.example.chefapp.data
import com.example.chefapp.R

data class FoodItem(
    val name: String,          // Food item name
    val price: Int,            // Price of the item
    val quantity: Int,         // Quantity of the item
    val isVeg: Boolean,        // Veg or non-veg (true for veg, false for non-veg)
    val imageResId: Int        // Image resource ID for the food item
)

data class OrderInfo(
    val id: String,
    val time: String,
    val items: List<FoodItem>, // List of FoodItem objects
    val status: OrderStatus = OrderStatus.NEW
)

enum class OrderStatus {
    NEW,
    READY,
    PICKED_UP
}



// Extension function to calculate the total bill
fun OrderInfo.calculateTotalBill(): Int {
    return items.sumOf { it.price * it.quantity }
}

// Sample data for demonstration in App
val dummyOrders = listOf(
    OrderInfo(
        id = "4002",
        time = "8:00 PM",
        items = listOf(
            FoodItem(
                name = "Food Item 1",
                price = 200,
                quantity = 1,
                isVeg = true,
                imageResId = R.drawable.dummy_food_image
            ),
            FoodItem(
                name = "Food Item 2",
                price = 300,
                quantity = 2,
                isVeg = false,
                imageResId = R.drawable.dummy_food_image
            )
        ),
    ),
    OrderInfo(
        id = "4003",
        time = "9:00 PM",
        items = listOf(
            FoodItem(
                name = "Food Item 3",
                price = 150,
                quantity = 1,
                isVeg = true,
                imageResId = R.drawable.dummy_food_image
            ),
            FoodItem(
                name = "Food Item 4",
                price = 250,
                quantity = 3,
                isVeg = false,
                imageResId = R.drawable.dummy_food_image
            ),
            FoodItem(
                name = "Food Item 5",
                price = 50,
                quantity = 3,
                isVeg = false,
                imageResId = R.drawable.dummy_food_image
            )
        ),
    )
)