package com.example.userapp.features.auth.data.retrofit


import com.example.userapp.features.auth.data.TwilioNetworkDataSource
import com.example.userapp.features.auth.data.models.TwilioVerificationResponse
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
import retrofit2.http.Header
import retrofit2.http.POST
import javax.inject.Inject
import javax.inject.Singleton

private const val BASE_URL = "https://verify.twilio.com/v2/"
private const val SERVICE_SID = "VAb70c7353c8597472fec3d937e736456b"

private interface RetrofitTwilioNetworkApi {
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

@Singleton
internal class RetrofitTwilioNetwork @Inject constructor(
    networkJson: Json,
    okhttpCallFactory: Lazy<Call.Factory>
) : TwilioNetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .callFactory { okhttpCallFactory.get().newCall(it) }
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType())
        )
        .build()
        .create(RetrofitTwilioNetworkApi::class.java)


    override suspend fun sendOTP(
        phoneNumber: String,
        channel: String,
        authHeader: String
    ): Response<TwilioVerificationResponse> =
        networkApi.sendOTP(
            phoneNumber = phoneNumber,
            channel = channel,
            authHeader =
            authHeader
        )

    override suspend fun verifyOTP(
        phoneNumber: String,
        sid: String,
        code: String,
        authHeader: String
    ): Response<ResponseBody> =
        networkApi.verifyOTP(
            phoneNumber = phoneNumber,
            sid = sid,
            code = code,
            authHeader = authHeader
        )
}