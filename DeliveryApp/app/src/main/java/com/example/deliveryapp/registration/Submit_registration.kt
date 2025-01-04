package com.example.deliveryapp.registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.deliveryapp.R

@Composable
fun RegistrationDone() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.verified),
            contentDescription = null,
            modifier = Modifier.height(150.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Your application is submitted successfully.",
            modifier = Modifier.padding(
                horizontal = 24.dp,
            ),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W600),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Please wait and check your application status under My Application.",
            modifier = Modifier.padding(
                horizontal = 24.dp,
            ),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium

            )
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedButton(
            onClick = {}
        ) {
            Text(text = "Okay")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun RegistrationDonePreview() {
    RegistrationDone()
}