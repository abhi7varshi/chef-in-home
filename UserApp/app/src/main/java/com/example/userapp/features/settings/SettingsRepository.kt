package com.example.userapp.features.settings

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.example.userapp.Settings

// Create DataStore instance
val Context.settingsDataStore: DataStore<Settings> by dataStore(
    fileName = "settings.pb",
    serializer = SettingsSerializer
)

class SettingsRepository(private val context: Context) {
    // Read settings
    val settingsFlow = context.settingsDataStore.data

    // Update settings
    suspend fun updateDarkMode(enabled: Boolean) {
        context.settingsDataStore.updateData { currentSettings ->
            currentSettings.toBuilder()
                .setDarkModeEnabled(enabled)
                .build()
        }
    }
}