package com.example.userapp.features.auth.data.di

import com.example.userapp.features.auth.data.TwilioNetworkDataSource
import com.example.userapp.features.auth.data.retrofit.RetrofitTwilioNetwork
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    internal abstract fun bindsTwilioNetworkDataSource(
        network: RetrofitTwilioNetwork
    ): TwilioNetworkDataSource
}