package com.example.userapp.features.auth.data.repository

import com.example.userapp.BuildConfig
import com.example.userapp.features.auth.data.remote.TwilioApi
import okhttp3.Credentials
import javax.inject.Inject

class OTPRepository @Inject constructor(
    private val networkApi: TwilioApi,
) {
    //Twilio account credentials
    private val authCredentials = Credentials.basic(
        BuildConfig.TWILIO_ACCOUNT_SID,
        BuildConfig.TWILIO_AUTH_TOKEN
    )

    suspend fun sendOTP(phoneNumber: String) =
        networkApi.sendOTP(
            phoneNumber = "+91$phoneNumber",
            authHeader = authCredentials
        )

    suspend fun verifyOTP(phoneNumber: String, code: String, sid: String) =
        networkApi.verifyOTP(
            phoneNumber = phoneNumber,
            code = code,
            sid = sid,
            authHeader = authCredentials,
        )
}