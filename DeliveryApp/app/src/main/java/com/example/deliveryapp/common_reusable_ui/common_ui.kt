@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.deliveryapp.common_reusable_ui

import android.provider.CalendarContract.Colors
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deliveryapp.R

//Custom-TextField
@Composable
fun CustomTextFieldWithIcon(
    textValue: String?,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    icon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
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
            leadingIcon = icon,
            trailingIcon = trailingIcon,
            label = { Text(text = label) },
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 10.dp
                )
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
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(horizontal = 16.dp).clickable {
                print("Hello Bhai")
            },
        shape = RoundedCornerShape(10.dp),
        color = MaterialTheme.colorScheme.surfaceContainer,
    ) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp)

            ) {
                Column() {
                    Text(text = "Order No.")
                    Text(text = "#$orderId")
                }
                Surface(
                    color = statusColor.copy(alpha = 0.2f),
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text(
                        text = status, style = MaterialTheme.typography.titleMedium.copy(
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        ), modifier = Modifier.padding(horizontal = 4.dp)

                    )
                }

        }
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
fun CommonMediumAppBar(
    text: String
) {
    MediumTopAppBar(
        modifier = Modifier,
        navigationIcon = {
            IconButton(onClick = {}) {
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
                    containerColor = if (selectedTab.value == "Orders") Color(0xFF0990ff) else MaterialTheme.colorScheme.surfaceContainer,
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
                    containerColor = if (selectedTab.value == "Account") Color(0xFF0990ff) else MaterialTheme.colorScheme.surfaceContainer,
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
//        NavigationBarItem(
//
//            selected = selectedTab.value=="Orders",
//            onClick = {
//                selectedTab.value="Orders"
//                      },
//            icon = {
//                Icon(
//                    imageVector = Icons.Default.ShoppingCart, contentDescription = "Orders",)
//            },
//            enabled = selectedTab.value=="Orders",
//            label = {
//                Text(
//                    text = "Order",
//                    style = MaterialTheme.typography.titleSmall.copy(
//                        fontWeight = FontWeight.W500
//                    ))
//            },
//            alwaysShowLabel = true,
//            colors = NavigationBarItemDefaults.colors(
//                selectedIconColor = Color.White,
//                unselectedIconColor = Color.Black,
//                selectedTextColor = Color.White,
//                unselectedTextColor = Color.Black,
//                indicatorColor = MaterialTheme.colorScheme.primary
//            ),
//        )
//        NavigationBarItem(
//            selected = selectedTab.value == "Account",
//            onClick = {
//                selectedTab.value = "Account"
//            },
//            icon = {
//                Icon(imageVector = Icons.Default.AccountCircle,contentDescription = "Accounts")
//            },
//            enabled = selectedTab.value=="Accounts",
//            label = {
//                Text(text = "Accounts", style = MaterialTheme.typography.titleSmall.copy(
//                    fontWeight = FontWeight.W500
//                ))
//            },
//            alwaysShowLabel = true,
//            colors = NavigationBarItemDefaults.colors(
//                selectedIconColor = Color.White,
//                unselectedIconColor = Color.Black,
//                selectedTextColor = Color.White,
//                unselectedTextColor = Color.Black,
//                indicatorColor = MaterialTheme.colorScheme.primary
//            ),
//        )

    }
}