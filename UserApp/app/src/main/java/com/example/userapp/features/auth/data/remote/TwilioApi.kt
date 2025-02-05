package com.example.userapp.features.auth.data.remote


import com.example.userapp.features.auth.data.models.TwilioVerificationResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

private const val SERVICE_SID = "VAb70c7353c8597472fec3d937e736456b"

interface TwilioApi {
    //start verification api to send otp
    @POST("Services/$SERVICE_SID/Verifications")
    @FormUrlEncoded
    suspend fun sendOTP(
        @Field("To") phoneNumber: String,
        @Field("Channel") channel: String = "sms",
        @Header("Authorization") authHeader: String,
    ): Response<TwilioVerificationResponse>

    //verification check api to verifyOTP
    @POST("Services/$SERVICE_SID/VerificationCheck")
    @FormUrlEncoded
    suspend fun verifyOTP(
        @Field("To") phoneNumber: String,
        @Field("VerificationSid") sid: String,
        @Field("Code") code: String,
        @Header("Authorization") authHeader: String
    ): Response<ResponseBody>
}