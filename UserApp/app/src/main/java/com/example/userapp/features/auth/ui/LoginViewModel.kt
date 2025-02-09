package com.example.userapp.features.auth.ui

import android.app.Application
import android.content.Intent
import android.content.IntentSender
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userapp.features.auth.data.LocalStorage
import com.example.userapp.features.auth.data.repository.OTPRepository
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "LoginViewModel"

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val otpRepository: OTPRepository,
    private val localStorage: LocalStorage,
    private val firebaseAuth: FirebaseAuth,
    private val oneTapClient: SignInClient,
    private val application: Application
) : ViewModel() {

    //app state
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

    private val _googleSignInIntent = MutableSharedFlow<IntentSender?>()
    val googleSignInIntent: SharedFlow<IntentSender?> = _googleSignInIntent.asSharedFlow()

    init {
        _uiState.value = LoginUiState(user = firebaseAuth.currentUser)
    }

    fun launchGoogleSignIn() {
        val signInRequest = GetSignInIntentRequest.builder()
            .setServerClientId("134807327020-eeuulu48deneogugqh8a7tg1e9l5oo77.apps.googleusercontent.com") // Replace with your actual Firebase Web Client ID
            .build()

        oneTapClient.getSignInIntent(signInRequest)
            .addOnSuccessListener { pendingIntent ->
                viewModelScope.launch {
                    _googleSignInIntent.emit(pendingIntent.intentSender)
                }
            }
            .addOnFailureListener {
                _uiState.value =
                    _uiState.value.copy(errorMessage = "Google Sign-In Failed: ${it.message}")
            }
    }

    fun handleSignInResult(intent: Intent?) {
        try {
            val credential = oneTapClient.getSignInCredentialFromIntent(intent)
            val googleIdToken = credential.googleIdToken

            if (googleIdToken != null) {
                val firebaseCredential = GoogleAuthProvider.getCredential(googleIdToken, null)

                firebaseAuth.signInWithCredential(firebaseCredential)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            _uiState.value = _uiState.value.copy(user = firebaseAuth.currentUser)
                        } else {
                            _uiState.value =
                                _uiState.value.copy(errorMessage = "Firebase Auth Failed: ${task.exception?.message}")
                        }
                    }
            }
        } catch (e: Exception) {
            _uiState.value =
                _uiState.value.copy(errorMessage = "Google Sign-In Failed: ${e.message}")
        }
    }

    fun signOut() {
        firebaseAuth.signOut()
        _uiState.value = _uiState.value.copy(user = null)
    }

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
                    Log.d(TAG, "error response: ${response.errorBody()?.string()}")
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

    fun register(phoneNumber: String, userName: String, email: String) {
        viewModelScope.launch {
            val appId = application.packageName

            try {
                val response =
            } catch (e: Exception) {

            }
        }
    }
}