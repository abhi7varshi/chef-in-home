package com.example.userapp.features.auth.data.repository

import com.example.userapp.features.auth.data.remote.TwilioApi
import okhttp3.Credentials
import javax.inject.Inject

class OTPRepository @Inject constructor(
    private val networkApi: TwilioApi,
) {
    //Twilio account credentials
    private val authCredentials = Credentials.basic(
        "ACbb5c91cc4d03ac7e5784b497a7480bca", //account ssid
        "6869a233c403472cf036df6f56954fd9", //auth token
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