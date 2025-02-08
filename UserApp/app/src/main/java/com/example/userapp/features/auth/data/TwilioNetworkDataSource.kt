package com.example.userapp.features.auth.data

import com.example.userapp.features.auth.data.models.TwilioVerificationResponse
import okhttp3.ResponseBody
import retrofit2.Response

interface TwilioNetworkDataSource {
    suspend fun sendOTP(
        phoneNumber: String,
        channel: String = "sms",
        authHeader: String,
    ): Response<TwilioVerificationResponse>

    suspend fun verifyOTP(
        phoneNumber: String,
        sid: String,
        code: String,
        authHeader: String
    ): Response<ResponseBody>
}