package com.example.chefapp.ui.composable

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.rememberAsyncImagePainter
import com.example.chefapp.R
import com.example.chefapp.ui.theme.PrimaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDishScreen(navController: NavController) {
    val context = LocalContext.current
    var dishName by remember { mutableStateOf(TextFieldValue("")) }
    var dishPrice by remember { mutableStateOf(TextFieldValue("")) }
    var setQuantity by remember { mutableStateOf(TextFieldValue("")) }
    var selectedDishType by remember { mutableStateOf("Veg") }
    var selectedImageUri by remember { mutableStateOf<android.net.Uri?>(null) }
    val imagePicker =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.PickVisualMedia(),
            onResult = { uri -> selectedImageUri = uri }
        )

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PrimaryColor,
                ),
                title = {
                    Text(
                        "Create Dish",
                        color = Color.White
                    )
                },
                navigationIcon = {
                    if (navController.previousBackStackEntry != null) {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }
                    }
                }
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                // Placeholder for the image
                Card(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                        .height(240.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        // Image
                        Image(
                            painter = if (selectedImageUri != null) {
                                rememberAsyncImagePainter(model = selectedImageUri)
                            } else {
                                painterResource(id = R.drawable.dummy_food_image)
                            },
                            contentDescription = "Dish Image",
                            modifier = Modifier.fillMaxSize()
                        )


                        // Add Button
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(8.dp),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Button(
                                onClick = {
                                    imagePicker.launch(
                                        PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                    )
                                },
                                modifier = Modifier.fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xBC000000),
                                    contentColor = Color.White
                                ),
                                elevation = null
                            ) {
                                Text("Add an Image")
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Text field for entering the dish name
                OutlinedTextField(
                    value = dishName,
                    onValueChange = { dishName = it },
                    label = { Text("Enter Dish Name!") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Description text field
                OutlinedTextField(
                    value = dishName,
                    onValueChange = { dishName = it },
                    label = { Text("Enter Description!") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Select Dish Type Text
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = Color.Gray,
                            shape = androidx.compose.foundation.shape.RoundedCornerShape(4.dp) // Rounded corners
                        )
                        .clip(androidx.compose.foundation.shape.RoundedCornerShape(8.dp)) // Clip content to match the border
                        .padding(8.dp)
                ) {
                    Column {
                        // Select Dish Type Text
                        Text(
                            text = "Select Dish Type",
                            fontSize = 16.sp,
                            color = Color.Black,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp) // Space below the text
                        )

                        // Radio Buttons for Veg/Non-Veg
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            RadioButton(
                                selected = selectedDishType == "Veg",
                                onClick = { selectedDishType = "Veg" }
                            )
                            Text(
                                text = "Veg",
                                modifier = Modifier.padding(start = 8.dp)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            RadioButton(
                                selected = selectedDishType == "Non-Veg",
                                onClick = { selectedDishType = "Non-Veg" }
                            )
                            Text(
                                text = "Non-Veg",
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                }

                Spacer(Modifier.padding(4.dp))

                // Price text field
                OutlinedTextField(
                    value = dishPrice,
                    onValueChange = {
                        dishPrice = it
                    },
                    label = { Text("Enter Price!") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number // Set keyboard to numeric
                    )
                )

                Spacer(Modifier.padding(4.dp))

                // Set available Quantity
                OutlinedTextField(
                    value = setQuantity,
                    onValueChange = {
                        setQuantity = it
                    },
                    label = { Text("Set available quantity (gram)") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number // Set keyboard to numeric
                    )
                )
            }


            // Add Dish button
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor),
                onClick = { /* Handle add dish action */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Add Dish to Menu")
            }
        }
    }
}

@Preview
@Composable
fun AddDishScreenPreview() {
    AddDishScreen(navController = NavController(LocalContext.current))
}
