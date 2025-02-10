package com.example.deliveryapp.dashBoard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deliveryapp.R
import com.example.deliveryapp.common_reusable_ui.CommonBox
import com.example.deliveryapp.common_reusable_ui.ProfileCommonBox
import com.example.deliveryapp.common_reusable_ui.ProfileDetails

@Composable
fun AccountScreen(
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Column(
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.man),
                        contentDescription = null,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(RoundedCornerShape(50.dp)),
                        contentScale = ContentScale.Crop,
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        ProfileDetails(
                            text = "Aman Sharma",
                            profileIcon = {
                                Icon(
                                    imageVector = Icons.Outlined.Person,
                                    contentDescription = null,
                                    modifier = Modifier.size(18.dp),
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            },
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        ProfileDetails(
                            text = "+91-9988776655",
                            profileIcon = {
                                Icon(
                                    imageVector = Icons.Outlined.Call,
                                    contentDescription = null,
                                    modifier = Modifier.size(18.dp),
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            },
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        ProfileDetails(
                            text = "amansharma@gmail.com",
                            profileIcon = {
                                Icon(
                                    imageVector = Icons.Outlined.MailOutline,
                                    contentDescription = null,
                                    modifier = Modifier.size(18.dp),
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            },
                        )
                    }
                    Spacer(modifier=Modifier.width(2.dp))
                    Surface(
                        color = MaterialTheme.colorScheme.surface,
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.width(80.dp)
                    ) {
                        Text("  4.1 ⭐", style = MaterialTheme.typography.titleSmall.copy(fontSize = 12.sp), color = MaterialTheme.colorScheme.onSurface)
                    }
                }
            }
            //Text
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Options",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(16.dp))
            //Edit profile
            ProfileCommonBox(
                text = "Edit Profile",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            //
            ProfileCommonBox(
                text = "Registration",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Call,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            //support
            ProfileCommonBox(
                text = "Support",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Call,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            //FAQs
            ProfileCommonBox(
                text = "FAQs",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = null,
                        tint =MaterialTheme.colorScheme.primary
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            //T$C
            ProfileCommonBox(
                text = "Terms and Conditions",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.DateRange,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            //Privacy Policy
            ProfileCommonBox(
                text = "Privacy Policy",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Done,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            //Logout
            ProfileCommonBox(
                text = "Logout",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.ExitToApp,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },

            )
        }
    }
}


@Composable
@Preview(showBackground = true)
fun AccountScreenPreview() {
    AccountScreen(modifier = Modifier)
}