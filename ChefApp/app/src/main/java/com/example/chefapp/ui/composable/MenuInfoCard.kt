package com.example.chefapp.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.chefapp.EditDishRoute
import com.example.chefapp.R

@Composable
fun MenuInfoCard(
    navController: NavController
) {
    val context = LocalContext.current
    var checked = remember { mutableStateOf(true) }

    OutlinedCard(
        colors = androidx.compose.material3.CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            // Items List
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                verticalArrangement = Arrangement.Top
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    // Food Name and Veg/Non-Veg Icon
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp)
                    ) {
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                // Food Name
                                Text(
                                    text = "Food Item 1",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )

                                Spacer(modifier = Modifier.width(4.dp))
                                //veg or non-veg icon
                                Image(
                                    painter = painterResource(id = R.drawable.veg_icon),
                                    contentDescription = "Veg/Non-veg",
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                            Text(
                                text = "This is a detailed description of the food item, explaining its ingredients, preparation, and any other relevant information.",
                                Modifier.padding(4.dp)
                            )

                            Spacer(modifier = Modifier.padding(8.dp))

                            Row {
                                Text(
                                    text = "Price: ",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                                Text(text = "₹200", fontSize = 16.sp)
                            }

                            Spacer(modifier = Modifier.padding(4.dp))

                            Row {
                                Text(
                                    text = "Available Quantity: ",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                                Text(text = "500g", color = Color.Black, fontSize = 16.sp)
                            }


                        }
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Switch Toggle Button
                        Switch(
                            checked = checked.value,
                            onCheckedChange = {
                                checked.value = it
                            },
                            modifier = Modifier.scale(0.8f),
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color(0xFF4CAF50),
                                checkedTrackColor = Color(0xFF81C784)
                            )
                        )

                        // Food Image
                        Image(
                            painter = painterResource(R.drawable.dummy_food_image),
                            contentDescription = "Dummy Image",
                            modifier = Modifier.size(100.dp)
                        )

                        //Edit Button
                        OutlinedButton(
                            onClick = {
                                navController.navigate(route = EditDishRoute)
                            },
                            modifier = Modifier
                                .height(30.dp),
                        ) {
                            Text(
                                "Edit",
                                style = androidx.compose.material3.MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
@Preview
fun MenuInfoCardPreview() {
    MenuInfoCard(
        navController = rememberNavController()
    )
}