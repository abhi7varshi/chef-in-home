package com.example.deliveryapp.registration

import android.app.DatePickerDialog
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deliveryapp.common_reusable_ui.CustomTextFieldWithIcon
import com.example.deliveryapp.ui.theme.DeliveryAppTheme
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun PersonalInfo() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        var scrollState = rememberScrollState()
        var firstName by remember { mutableStateOf("") }
        var lastName by remember { mutableStateOf("") }
        var middleName by remember { mutableStateOf("") }
        var dob by remember { mutableStateOf("") }
        var primaryNumber by remember { mutableStateOf("") }
        var alternativeNumber by remember { mutableStateOf("") }
        var bloodGroup by remember { mutableStateOf("") }
        var city by remember { mutableStateOf("") }
        var referalCode by remember { mutableStateOf("") }
        var address by remember { mutableStateOf("") }
        var languages by remember { mutableStateOf("") }
        var selectedDate by remember { mutableStateOf<String?>(null) }
        var showDatePickerDialog by remember { mutableStateOf("false") }
        var dateOfBirth by remember { mutableStateOf("") }
        val dateFormatter = SimpleDateFormat("dd/mm/yyyy", Locale.getDefault())

        val caledar= Calendar.getInstance()
        val year= Calendar.YEAR
        val month= Calendar.MONTH
        val day = Calendar.DAY_OF_MONTH



        Spacer(
            modifier = Modifier.height(
                16.dp
            )
        )
        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Personal Information",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.W500,
                    fontSize = 24.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Enter the details below so we can get to know and serve you better",
                maxLines = 2,
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            CustomTextFieldWithIcon(
                modifier = Modifier,
                onValueChange = { firstName = it },
                value = firstName,
                label = "Please enter first name",
                textValue = "First Name"
            )
            Spacer(modifier = Modifier.height(8.dp))
            CustomTextFieldWithIcon(
                modifier = Modifier,
                onValueChange = { middleName = it },
                value = middleName,
                label = "Please enter last name",
                textValue = "Last Name"
            )
            Spacer(modifier = Modifier.height(8.dp))
            CustomTextFieldWithIcon(
                modifier = Modifier,
                onValueChange = { lastName = it },
                value = lastName,
                label = "Please enter last name",
                textValue = "Last Name"
            )

            Spacer(modifier = Modifier.height(8.dp))
            CustomTextFieldWithIcon(
                modifier = Modifier,
                onValueChange = { dob = it },
                value = dob,
                label = "dd-mm-yyyy",
                trailingIcon = {Icon(imageVector = Icons.Default.DateRange, contentDescription = "Calendar")},
                textValue = "Date of birth"
            )
            Spacer(modifier = Modifier.height(8.dp))
            CustomTextFieldWithIcon(
                modifier = Modifier,
                onValueChange = { primaryNumber = it },
                value = primaryNumber,
                label = "+9999999999",
                textValue = "Primary Number"
            )
            Spacer(modifier = Modifier.height(8.dp))
            CustomTextFieldWithIcon(
                modifier = Modifier,
                onValueChange = { alternativeNumber = it },
                value = alternativeNumber,
                label = "+9898989898",
                textValue = "Alternative Number"
            )
            Spacer(modifier = Modifier.height(8.dp))
            CustomTextFieldWithIcon(
                modifier = Modifier,
                onValueChange = { bloodGroup = it },
                value = bloodGroup,
                label = "AB+",
                textValue = "Blood Group"
            )
            Spacer(modifier = Modifier.height(8.dp))
            CustomTextFieldWithIcon(
                modifier = Modifier,
                onValueChange = { city = it },
                value = city,
                label = "e.g. Bengaluru",
                textValue = "City"
            )
            Spacer(modifier = Modifier.height(8.dp))
            CustomTextFieldWithIcon(
                modifier = Modifier,
                onValueChange = { languages = it },
                value = languages,
                label = "e.g. Hindi",
                textValue = "Language"
            )

            Spacer(modifier = Modifier.height(8.dp))
            CustomTextFieldWithIcon(
                modifier = Modifier,
                onValueChange = { referalCode = it },
                value = referalCode,
                label = "Enter referral code",
                textValue = "Referral code(optional)"
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 16.dp),
                onClick = {},
                shape = RoundedCornerShape(12.dp),
            ) {
                Text(text = "Submit")
            }
            Spacer(modifier = Modifier.height(16.dp))

        }

    }
}

@Composable
@Preview(showBackground = true)
fun PersonalInfoPreview() {
    DeliveryAppTheme {
        PersonalInfo()
    }
}