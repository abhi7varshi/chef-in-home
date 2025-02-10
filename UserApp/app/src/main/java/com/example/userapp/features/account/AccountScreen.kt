package com.example.userapp.features.account

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Account", fontSize = 20.sp) }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Profile Section
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Hard-coded profile image: a circle with a Person icon
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(Color.Gray),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "Profile Image",
                            tint = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(text = "Jayaditya", fontSize = 16.sp)
                        Text(text = "+91 9902551692", fontSize = 14.sp, color = Color.Gray)
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            // Hard-coded Account Options Section
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
            ) {
                Column {
                    // Option: My Orders
                    AccountOptionItem(
                        title = "My Orders",
                        icon = Icons.Filled.ShoppingCart,
                        onClick = { /* Handle My Orders click */ }
                    )
                    Divider(color = Color.LightGray, thickness = 1.dp)
                    // Option: My Collection
                    AccountOptionItem(
                        title = "My Collection",
                        icon = Icons.Filled.Favorite,
                        onClick = { /* Handle My Collection click */ }
                    )
                    Divider(color = Color.LightGray, thickness = 1.dp)
                    // Option: Settings
                    AccountOptionItem(
                        title = "Settings",
                        icon = Icons.Filled.Settings,
                        onClick = { /* Handle Settings click */ }
                    )
                    Divider(color = Color.LightGray, thickness = 1.dp)
                    // Option: Share Feedback
                    AccountOptionItem(
                        title = "Share Feedback",
                        icon = Icons.Filled.Build,
                        onClick = { /* Handle Feedback click */ }
                    )
                    Divider(color = Color.LightGray, thickness = 1.dp)
                    // Option: Rate Us
                    AccountOptionItem(
                        title = "Rate Us",
                        icon = Icons.Filled.ThumbUp,
                        onClick = { /* Handle Rate Us click */ }
                    )
                    Divider(color = Color.LightGray, thickness = 1.dp)
                    // Option: Help
                    AccountOptionItem(
                        title = "Help",
                        icon = Icons.Default.Info,
                        onClick = { /* Handle Help click */ }
                    )
                    Divider(color = Color.LightGray, thickness = 1.dp)
                    // Option: About Us
                    AccountOptionItem(
                        title = "About Us",
                        icon = Icons.Filled.Info,
                        onClick = { /* Handle About Us click */ }
                    )
                }
            }
        }
    }
}


@Composable
fun AccountOptionItem(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = title, fontSize = 14.sp)
    }
}
