package com.devfalah.remoteConfig

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devfalah.remoteConfig.data.RemoteConfig
import com.devfalah.remoteConfig.data.RemoteConfigManager

@Composable
fun RemoteConfigScreen(remoteConfigManager: RemoteConfigManager) {
    var config by remember { mutableStateOf<RemoteConfig?>(null) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        config = remoteConfigManager.fetchConfig()
        isLoading = false
    }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when {
                isLoading -> CircularProgressIndicator()
                config != null -> {
                    Text(text = config?.remoteVariables?.welcomeMessage.orEmpty())
                    config?.featureFlags?.forEach { flag ->
                        Text(text = "${flag.id} enabled: ${flag.enabled}")
                    }
                    Text(text = "Maintenance mode: ${config?.appConfig?.maintenanceMode}")
                    Text(text = "Force update: ${config?.appConfig?.forceUpdate}")
                    Text(text = "Latest version: ${config?.appConfig?.latestVersion}")
                    Text(text = "Min required version: ${config?.appConfig?.minRequiredVersion}")
                    Text(text = "Max items per page: ${config?.remoteVariables?.maxItemsPerPage}")
                    Text(text = "Cache duration hours: ${config?.remoteVariables?.cacheDurationHours}")
                    Text(text = "API endpoint: ${config?.remoteVariables?.apiEndpoint}")
                }
            }
        }
    }
}
