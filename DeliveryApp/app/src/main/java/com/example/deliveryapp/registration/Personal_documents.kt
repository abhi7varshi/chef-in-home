package com.example.deliveryapp.registration

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.deliveryapp.common_reusable_ui.CommonBox
import com.example.deliveryapp.common_reusable_ui.CommonMediumAppBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PersonalDocument(){
    Scaffold(
        topBar = {
           CommonMediumAppBar(text = "Personal documents", )
        },
    ) { innerPadding->
       Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
           Column(modifier = Modifier.padding(horizontal = 16.dp)) {
               Text(text = "Upload focused photo of below documents for faster verification.")
               Spacer(modifier = Modifier.height(16.dp))
               CommonBox(text = "Aadhar Card", trailingIcon = { Icon(imageVector = Icons.Default.KeyboardArrowRight, tint = Color.Gray, contentDescription = null) })
               Spacer(modifier = Modifier.height(20.dp))
               CommonBox(text = "PAN Card", trailingIcon = { Icon(imageVector = Icons.Default.KeyboardArrowRight, tint = Color.Gray, contentDescription = null) })
               Spacer(modifier = Modifier.height(20.dp))
               CommonBox(text = "Driving License", trailingIcon = { Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null) })
           }
       }


    }
}

@Composable
@Preview(showBackground = true)
fun PersonalDocumentPreview(){
    MaterialTheme {
        PersonalDocument()
    }
}