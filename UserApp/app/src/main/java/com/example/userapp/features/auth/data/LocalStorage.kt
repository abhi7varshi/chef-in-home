package com.example.userapp.features.auth.data

import com.example.userapp.features.auth.data.models.TwilioVerificationResponse

interface LocalStorage {
    fun saveOTPVerificationResponse(response: TwilioVerificationResponse)
    fun getVerificationResponse(): TwilioVerificationResponse
}