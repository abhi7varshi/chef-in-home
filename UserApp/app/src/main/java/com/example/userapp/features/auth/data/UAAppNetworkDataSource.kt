package com.example.userapp.features.auth.data

import okhttp3.ResponseBody
import retrofit2.Response

interface UAAppNetworkDataSource {
    suspend fun register(
        appId: String,
        phoneNumber: String,
        userName: String,
        email: String
    ): Response<ResponseBody>
}