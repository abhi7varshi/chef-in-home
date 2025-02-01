package com.example.deliveryapp.registration

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deliveryapp.common_reusable_ui.CommonMediumAppBar
import com.example.deliveryapp.common_reusable_ui.CommonUploadDocumentBox

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UploadDocument(
    text: String
) {
    Scaffold(
        topBar = {
            CommonMediumAppBar(text = text)
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(modifier = Modifier.padding(horizontal = 16.dp))
            {

                Text(
                    text = "Upload focused photo of below documents for faster verification.",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(40.dp))
                CommonUploadDocumentBox(side = "Front",text = text)
                Spacer(modifier = Modifier.height(24.dp))
                CommonUploadDocumentBox(side = "Back",text = text)

            }
        }

    }
}

@Composable
@Preview
fun UploadDocumentPreview() {
    UploadDocument("Pan card")
}