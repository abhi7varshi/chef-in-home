package com.example.userapp.features.auth.data.retrofit

import dagger.Lazy
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import javax.inject.Inject
import javax.inject.Singleton

private const val BASE_URL = "http://localhost:8080/api/"

private interface RetrofitUAAppNetworkApi {
    @POST("auth/register")
    @FormUrlEncoded
    suspend fun register(
        @Field("appId") appId: String,
        @Field("appId") phoneNumber: String,
        @Field("username") userName: String,
        @Field("email") email: String
    ): Response<ResponseBody>
}

@Singleton
internal class RetrofitUAAppNetwork @Inject constructor(
    networkJson: Json,
    okhttpCallFactory: Lazy<Call.Factory>
) : RetrofitUAAppNetworkApi {

    private val networkApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .callFactory { okhttpCallFactory.get().newCall(it) }
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType())
        )
        .build()
        .create(RetrofitUAAppNetworkApi::class.java)

    override suspend fun register(
        appId: String,
        phoneNumber: String,
        userName: String,
        email: String
    ): Response<ResponseBody> =
        networkApi.register(
            appId = appId,
            phoneNumber = phoneNumber,
            userName = userName,
            email = email
        )
}

