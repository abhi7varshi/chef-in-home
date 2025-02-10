@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.deliveryapp.common_reusable_ui

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.deliveryapp.R
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import com.example.deliveryapp.navigation.Routes
import kotlinx.coroutines.selects.select

@Composable
fun OtpInput(
    otpValue: String,
    onOtpChange: (String) -> Unit
) {
    val focusManager = LocalFocusManager.current
    val maxOtpLength = 6

    BasicTextField(
        value = otpValue,
        onValueChange = { newValue ->
            if (newValue.length <= maxOtpLength && newValue.all { it.isDigit() }) {
                onOtpChange(newValue)
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword,
            imeAction = ImeAction.Done
        ),
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                (0 until maxOtpLength).forEach { index ->
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                            .background(Color.White, RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = otpValue.getOrNull(index)?.toString() ?: "",
//                            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .focusable()
    )
}


@Composable
fun UAButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        shape = ShapeDefaults.Medium,
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
        modifier = modifier
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.W600,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}

//Custom-TextField
@Composable
fun CustomTextFieldWithIcon(
    textValue: String?,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    modifier: Modifier = Modifier,

    ) {
    Column {
        textValue?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight.W400,
                    fontSize = 18.sp
                ),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            )
        }
        Spacer(modifier.height(8.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            shape = RoundedCornerShape(12.dp),
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            label = { Text(text = label) },
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 10.dp
                ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = modifier.height(8.dp))
    }
}

@Composable
fun commonButton(
    text: String,
    onclick: () -> Unit,
) {
    Button(
        onClick = onclick,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(text = text)
    }
}

@Composable
fun CommonBox(
    text: String,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
            .border(
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(width = 1.dp, color = Color.Black)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = text, style = MaterialTheme.typography.titleMedium)
            if (trailingIcon != null) {
                Log.d("passed", "Inside if")
                trailingIcon()
            } else {
                Log.d("failed", "Inside else")
            }

        }
    }

}


@Composable
fun ProfileCommonBox(
    text: String,
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                if (leadingIcon != null) {
                    leadingIcon()
                }
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = text, style = MaterialTheme.typography.titleMedium)
            }
            if (trailingIcon != null) {
                trailingIcon()
            }

        }
    }

}

@Composable
fun CommonOrderBox(
    status: String,
    orderId: String,
    statusColor: Color,
    isExpanded: Boolean,
    onSingleTap: () -> Unit,
    onDoubleTap: () -> Unit,
    navController: NavController
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { onSingleTap() },
                    onDoubleTap = { onDoubleTap() }
                )
            },
        shape = RoundedCornerShape(12.dp),
        color = Color.White,
//        color = MaterialTheme.colorScheme.surfaceContainerLow,
        shadowElevation = 5.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Order Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = "Order No.", fontWeight = FontWeight.Bold)
                    Text(text = "#$orderId", style = MaterialTheme.typography.bodyMedium)
                }
                Surface(
                    color = statusColor.copy(alpha = 0.2f),
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text(
                        text = status,
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontSize = 12.sp
                        ),
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            if (isExpanded) {
                Spacer(modifier = Modifier.height(12.dp))

                // Pickup Details
                Column {
                    PickupItem("Pickup Center-1", "Iyengar Bakery, HSR Bengaluru", "Mysore Pak", 500, 2)
                    Spacer(modifier = Modifier.height(8.dp))
                    PickupItem("Pickup Center-2", "Nikita Store, HSR Bengaluru", "Besan Ladoo", 500, 2)
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Payment Info
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Total: ₹2100", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                   if (statusColor==Color.Green){
                       Text(text =  "✅ Paid", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                   }
                   else if (statusColor ==Color.Red){
                       Text(text =  "❌ Cancelled", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                   }
                    else
                   {
                       Text(text =  "⌛ Pending", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                   }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Confirm Pickup Button
                if (statusColor != Color.Green && statusColor != Color.Red) {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        onClick = { /* Handle Pickup Confirmation */
                            navController.navigate(Routes.DeliveryScreen.name)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "Confirm Pickup",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

// Pickup Item Composable for reusability
@Composable
fun PickupItem(centerName: String, address: String, itemName: String, weight: Int, quantity: Int) {
    Column {
        Text(text = centerName, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Text(text = address, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
        Text(text = "🛒 $itemName - ${weight}g (Qty: $quantity)", fontSize = 14.sp)
    }
}


@Composable
fun CommonUploadDocumentBox(
    text: String,
    side: String
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .border(
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(width = 1.dp, color = Color.Black)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = "$side side photo of your $text with clear name and photo",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 32.dp)
            )
            Image(
                painter = painterResource(R.drawable.document),
                contentDescription = "Document",
                modifier = Modifier.height(80.dp)
            )
            OutlinedButton(
                onClick = {},
            ) {
                Text(text = "Upload Photo")
            }

        }
    }

}

@Composable
fun CommonCenterAlignedAppBar(
    text: String,
    navController: NavController
) {
    CenterAlignedTopAppBar(
        modifier = Modifier,
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Go Back"
                )
            }
        },
        title = {
            Text(
                text = "$text",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W600)
            )
        },
    )
}

@Composable
fun CommonMediumAppBar(
    text: String,
) {
    MediumTopAppBar(
        modifier = Modifier,
        navigationIcon = {
            IconButton(onClick = {

            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Go Back"
                )
            }
        },
        title = {
            Text(
                text = "$text details",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W600)
            )
        },
    )
}

@Composable
fun ProfileDetails(
    text: String,
    profileIcon: @Composable (() -> Unit)? = null,
) {
    Row(horizontalArrangement = Arrangement.Center) {
        if (profileIcon != null) {
            profileIcon()
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text, style = MaterialTheme.typography.bodySmall.copy(fontSize = 16.sp))

    }
}

@Composable
fun BottomNavigationBar(
    selectedTab: MutableState<String>
) {
    NavigationBar(
        containerColor = Color.White,
        modifier = Modifier.border(
            border = BorderStroke(width = 8.dp, color = Color.Transparent),
            shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
        ),

        ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                modifier = Modifier.width(150.dp),
                onClick = { selectedTab.value = "Orders" },
                colors = ButtonColors(
                    containerColor = if (selectedTab.value == "Orders") MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceContainer,
                    contentColor = if (selectedTab.value == "Orders") MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = Color.Transparent
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Row(horizontalArrangement = Arrangement.SpaceAround) {
                    Icon(imageVector = Icons.Outlined.ShoppingCart, contentDescription = "Orders")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Orders")

                }
            }
            Button(
                modifier = Modifier.width(150.dp),
                onClick = { selectedTab.value = "Account" },
                colors = ButtonColors(
                    containerColor = if (selectedTab.value == "Account") MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceContainer,
                    contentColor = if (selectedTab.value == "Account") MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = Color.Transparent
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                    Icon(imageVector = Icons.Outlined.AccountCircle, contentDescription = "Account")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Account")

                }
            }
        }
    }
}

@Composable
fun otpInput() {

}