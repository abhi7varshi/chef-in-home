package com.example.userapp.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun AppMainSearchTextField() {
    var textValue by remember { mutableStateOf("") }
    val iconSize: Dp = 20.dp

    SearchTextField(
        placeholder = "Restaurant name or a dish...",
        value = textValue,
        onValueChange = { textValue = it },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Button",
//                tint = zRedColor,
                modifier = Modifier.padding(horizontal = 3.dp)
            )
        },
        trailingIcon = {
            Row {
                Divider(
//                    color = zDarkGray,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                        .padding(horizontal = 5.dp)
                )
            }
        }
    )
}

@Preview
@Composable
fun AppMainSearchTextFieldPreview(){
    AppMainSearchTextField()
}