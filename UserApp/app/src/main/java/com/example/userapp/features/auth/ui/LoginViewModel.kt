package com.example.userapp.features.auth.ui

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userapp.features.auth.data.LocalStorage
import com.example.userapp.features.auth.data.repository.OTPRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "LoginViewModel"

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val otpRepository: OTPRepository,
    private val localStorage: LocalStorage
) : ViewModel() {

    //app state
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()


    //app events
    fun sendOTP(phoneNumber: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            try {
                //store the verification sid coming in the response, we need this to verify
                //the otp code which will expire in 10min
                val response = otpRepository.sendOTP(phoneNumber)

                if (response.isSuccessful) {
                    response.body()?.let {
                        localStorage.saveOTPVerificationResponse(it)
                    }
                } else {
                    Log.d(TAG, "response: ${response.body()}")
                    Log.d(TAG, "error response: ${response.errorBody()}")
                    Log.d(TAG, "response code: ${response.code()}")
                }

                Log.d(TAG, "response: ${response.body()}")
                _uiState.update { it.copy(isLoading = false) }
            } catch (e: Exception) {
                Log.d(TAG, "error: ${e.message}")
                e.printStackTrace()
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }

    fun verifyOTP(code: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            val verificationResponse = localStorage.getVerificationResponse()
            Log.d(TAG, "verificationResponse in storage: $verificationResponse")

            try {
                val response = otpRepository.verifyOTP(
                    phoneNumber = verificationResponse.to,
                    code = code,
                    sid = verificationResponse.sid
                )

                Log.d(TAG, "response: ${response.body()}")
                _uiState.update { it.copy(isLoading = false) }
            } catch (e: Exception) {
                Log.d(TAG, "error: ${e.message}")
                e.printStackTrace()
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }
}