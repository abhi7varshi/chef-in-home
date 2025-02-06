package com.example.userapp.features.auth.ui

import com.google.firebase.auth.FirebaseUser

data class LoginUiState(
    val isLoading: Boolean = false,
    val user: FirebaseUser? = null,
    val errorMessage: String? = null
)