package com.example.userapp.features.auth.data.prefs

import android.content.SharedPreferences
import com.example.userapp.features.auth.data.LocalStorage
import com.example.userapp.features.auth.data.models.TwilioVerificationResponse
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import javax.inject.Inject

//keys
private const val KEY_VERIFICATION_RESPONSE = "twilio_verification_response"

class SharedPreferencesStorage @Inject constructor(
    private val prefs: SharedPreferences
) : LocalStorage {
    private val json = Json { ignoreUnknownKeys = true }


    override fun saveOTPVerificationResponse(response: TwilioVerificationResponse) {
        val jsonString = json.encodeToString(response)
        prefs.edit().putString(KEY_VERIFICATION_RESPONSE, jsonString).apply()
    }

    override fun getVerificationResponse(): TwilioVerificationResponse {
        val jsonString = prefs.getString(KEY_VERIFICATION_RESPONSE, null) ?: ""
        return json.decodeFromString(jsonString)
    }
}