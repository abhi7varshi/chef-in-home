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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.deliveryapp.R
import com.example.deliveryapp.common_reusable_ui.CommonCenterAlignedAppBar
import com.example.deliveryapp.common_reusable_ui.CustomTextFieldWithIcon
import com.example.deliveryapp.navigation.Routes

@Composable
fun SignUP(modifier: Modifier,navController: NavController) {
  Scaffold(
      topBar = {
          CommonCenterAlignedAppBar("Sign Up",navController)
      }
  ) {
      innerPadding->  Box(
      modifier = Modifier
          .fillMaxSize().padding(innerPadding).padding(16.dp)
  ) {
      var emailId by remember { mutableStateOf("") }
      var pass by remember { mutableStateOf("") }
      var confirmPass by remember { mutableStateOf("") }


      Box() {
          Column {
              Image(
                  painter = painterResource(R.drawable.delivery_boy),
                  contentDescription = "Delivery Boy",
                  modifier = Modifier
                      .fillMaxWidth()
                      .padding(horizontal = 16.dp)
                      .fillMaxHeight(0.35f)
//                      .align(Alignment.TopCenter),
              )

              Text(
                  text = "Be a Delivery Agent",
                  style = MaterialTheme.typography.bodyMedium.copy(
                      fontWeight = FontWeight.W400,
                      fontSize = 18.sp
                  ),
                  modifier = Modifier.fillMaxWidth()
              )
              Text(
                  text = "Get a stable income monthly",
                  style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W500),
                  modifier = Modifier.fillMaxWidth()
              )

              Spacer(modifier = Modifier.height(32.dp))
              CustomTextFieldWithIcon(
                  modifier = Modifier,
                  onValueChange = { emailId = it },
                  icon = { Icon(imageVector = Icons.Default.Email, contentDescription = null) },
                  value = emailId,
                  label = "ex-abc@gmail.com",
                  textValue = "Enter Your Email",
              )
              Spacer(modifier = Modifier.padding(8.dp))
              CustomTextFieldWithIcon(
                  modifier = Modifier,
                  onValueChange = { pass = it },
                  icon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null) },
                  value = pass,
                  label = "xxxxxxx",
                  textValue = "Enter Your Password"

              )
              Spacer(modifier = Modifier.padding(8.dp))
              CustomTextFieldWithIcon(
                  modifier = Modifier,
                  onValueChange = { confirmPass = it },
                  icon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null) },
                  value = confirmPass,
                  label = "xxxxxxx",
                  textValue = "Confirm your Password"
              )
              Spacer(modifier = Modifier.height(16.dp))
              Button(
                  onClick = {
                      navController.navigate(Routes.HomeScreen.name)
                  },
                  shape = RoundedCornerShape(12.dp),
                  modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
              ) {
                  Text(text = "Sign Up")
              }
              Spacer(modifier = Modifier.height(8.dp))
          }
      }
  }
  }
}



//@Composable
//@Preview(showBackground = true)
//fun SignUpPreview(){
//    SignUP(modifier = Modifier.padding(8.dp))
//}