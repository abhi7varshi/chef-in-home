package com.example.delivery_app.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.deliveryapp.R
import com.example.deliveryapp.common_reusable_ui.CommonCenterAlignedAppBar
import com.example.deliveryapp.common_reusable_ui.CustomTextFieldWithIcon
import com.example.deliveryapp.navigation.Routes
import com.example.deliveryapp.ui.theme.DeliveryAppTheme


@Composable
fun SignIn(modifier: Modifier, navController: NavController) {
    Scaffold(
//        topBar = {
//            CommonCenterAlignedAppBar("Sign In",navController)
//        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding).padding(horizontal = 16.dp)

        ) {
            var phone by remember { mutableStateOf("") }
            Column {
                Image(
                    painter = painterResource(R.drawable.delivery_boy1),
                    contentDescription = "Delivery Boy",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .fillMaxHeight(0.40f)
                )
                Text(
                    text = "Be a Delivery Agent",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.W400,
                        fontSize = 18.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp)
                )
                Text(
                    text = "Get a stable income monthly",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W500),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp)
                )

                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    "Login or SignUp",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W500,),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                CustomTextFieldWithIcon(
                    modifier = Modifier,
                    onValueChange = { phone = it },
                    leadingIcon = {
                       Row(verticalAlignment = Alignment.CenterVertically) {
                           Spacer(modifier = Modifier.width(16.dp))

                           Image(
                               painter = painterResource(R.drawable.india_flag_icon),
                               contentDescription = null,
                               modifier = Modifier
                                   .height(16.dp)
                                   .width(16.dp)
                           )
                           Spacer(modifier = Modifier.width(4.dp))
                           Text(text = "+91", fontSize = 16.sp, fontWeight = FontWeight.W400)
                           Spacer(modifier = Modifier.width(8.dp))
                           VerticalDivider(
                               modifier = Modifier
                                   .height(height = 20.dp)
                           )
                           Spacer(modifier = Modifier.width(8.dp))
                       }
                   },
                    value = phone,
                    label = "Enter your Number",
                    textValue = "",

                )
                Spacer(modifier = Modifier.padding(8.dp))
                Button(
                    onClick = {
                        navController.navigate(Routes.HomeScreen.name)
                    },
                    colors = ButtonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                        disabledContainerColor = MaterialTheme.colorScheme.primary,
                        disabledContentColor = MaterialTheme.colorScheme.primary
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                ) {
                    Text(
                        text = "Continue",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(5.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    "By clicking in, I accept the term of service & privacy policy",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    HorizontalDivider(
                        modifier = Modifier
                            .width(177.dp)
                            .padding(start = 20.dp)
                    )

                    Spacer(Modifier.width(9.dp))

                    Text(
                        text = "or",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                    )

                    Spacer(Modifier.width(9.dp))

                    HorizontalDivider(
                        modifier = Modifier
                            .width(177.dp)
                            .padding(end = 20.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedButton(
                    onClick = {},
                    shape = ShapeDefaults.Medium,
                    border = BorderStroke(width = 1.dp, color = Color.Black.copy(alpha = 0.16f)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(R.drawable.google_logo),
                            contentDescription = "",
                            modifier = Modifier
                                .width(16.dp)
                                .height(16.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "Continue with Google",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W500,
                            color = MaterialTheme.colorScheme.secondary,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                }
            }

        }
    }
}
