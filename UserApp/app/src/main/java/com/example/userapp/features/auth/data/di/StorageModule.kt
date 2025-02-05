package com.example.userapp.features.auth.data.di

import com.example.userapp.features.auth.data.LocalStorage
import com.example.userapp.features.auth.data.prefs.SharedPreferencesStorage
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageModule {

    @Binds
    @Singleton
    abstract fun bindLocalStorage(
        impl: SharedPreferencesStorage
    ): LocalStorage
}