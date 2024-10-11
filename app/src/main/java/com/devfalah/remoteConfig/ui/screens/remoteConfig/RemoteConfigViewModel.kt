package com.devfalah.remoteConfig.ui.screens.remoteConfig

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devfalah.remoteConfig.data.RemoteConfig
import com.devfalah.remoteConfig.data.RemoteConfigManager
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class RemoteConfigViewModel(
    private val remoteConfigManager: RemoteConfigManager
) : ViewModel(), KoinComponent {
    var config = MutableStateFlow<RemoteConfig?>(null)
    var isLoading = MutableStateFlow(true)

    init {
        fetchRemoteConfig()
    }

    private fun fetchRemoteConfig() = viewModelScope.launch(IO) {
        try {
            val remoteConfig = remoteConfigManager.fetchConfig()
            config.value = remoteConfig
            isLoading.value = false
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
