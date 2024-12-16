package com.example.chefapp.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.chefapp.R
import com.example.chefapp.ui.theme.ChefAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(isDarkModeEnabled: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if(isDarkModeEnabled == true){
                Image(
                    painter = painterResource(id = R.drawable.open),
                    contentDescription = "Online"
                )
                Text("You are online.",fontSize = 28.sp)
                Text("Waiting for new orders!", fontSize = 16.sp)
            }else{
                Image(
                    painter = painterResource(id = R.drawable.offline),
                    contentDescription = "Offline"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ChefAppTheme {
        HomeContent(isDarkModeEnabled = true)
    }
}
