package com.example.deliveryapp.auth.data

import kotlinx.serialization.Serializable

@Serializable
data class AuthModel(
    val email: String,
    val token: String,
    val userName: String,
)