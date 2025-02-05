package com.example.userapp.features.auth.data.models

import kotlinx.serialization.Serializable

@Serializable
data class TwilioVerificationResponse(
    val sid: String,
    val to: String,
    val channel: String,
    val status: String,
    val valid: Boolean
)

