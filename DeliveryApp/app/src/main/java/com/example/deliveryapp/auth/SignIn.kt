package com.example.delivery_app.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deliveryapp.R
import com.example.deliveryapp.common_reusable_ui.CustomTextFieldWithIcon
import com.example.deliveryapp.ui.theme.DeliveryAppTheme

@Composable
fun SignIn(modifier: Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        var emailId by remember { mutableStateOf("") }
        var pass by remember { mutableStateOf("") }

        Column {
            Box() {
                Image(
                    painter = painterResource(R.drawable.delivery_boy),
                    contentDescription = "Delivery Boy",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .fillMaxHeight(0.45f)
                        .align(Alignment.TopCenter),
                )
            }
            Text(text = "Be a Delivery Agent",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.W400, fontSize = 18.sp),
                modifier = Modifier.fillMaxWidth().padding(start = 16.dp)
                )
            Text(text = "Get a stable income monthly",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W500),
                modifier = Modifier.fillMaxWidth().padding(start = 16.dp)
                )

            Spacer(modifier = Modifier.height(40.dp))
            CustomTextFieldWithIcon(
                modifier = Modifier,
                onValueChange = {emailId = it},
                icon = {Icon(imageVector = Icons.Default.Email, contentDescription = null)},
                value = emailId,
                label = "abc@gmail.com",
                textValue = "Enter your Email"
            )
            Spacer(modifier = Modifier.padding(8.dp))

            CustomTextFieldWithIcon(
                modifier = Modifier,
                onValueChange = {pass = it},
                icon = {Icon(imageVector = Icons.Default.Lock, contentDescription = null)},
                value = pass,
                label = "xxxxxxx",
                textValue = "Enter your Password"
            )
            Spacer(modifier = Modifier.padding(16.dp))
            Button (onClick = {}, shape = RoundedCornerShape(12.dp), modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
                Text(text = "Sign In", style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SignInPreview() {
    DeliveryAppTheme  {
        SignIn(modifier = Modifier.padding(8.dp))
    }
}