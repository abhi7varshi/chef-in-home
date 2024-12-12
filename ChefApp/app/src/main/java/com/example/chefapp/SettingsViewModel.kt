package com.example.chefapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class SettingsViewModel(private val repository: SettingsRepository) : ViewModel() {
    // Expose dark mode as a Flow
    val darkModeEnabled = repository.settingsFlow.map { it.darkModeEnabled }

    // Update dark mode setting
    fun setDarkMode(enabled: Boolean) {
        viewModelScope.launch {
            repository.updateDarkMode(enabled)
        }
    }
}