package com.devfalah.remoteConfig.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteConfig(
    @SerialName("app_config") val appConfig: AppConfig,
    @SerialName("feature_flags") val featureFlags: List<FeatureFlag>,
    @SerialName("remote_variables") val remoteVariables: RemoteVariables
)

@Serializable
data class AppConfig(
    @SerialName("min_required_version") val minRequiredVersion: String,
    @SerialName("latest_version") val latestVersion: String,
    @SerialName("force_update") val forceUpdate: Boolean,
    @SerialName("update_message") val updateMessage: String,
    @SerialName("maintenance_mode") val maintenanceMode: Boolean,
    @SerialName("maintenance_message") val maintenanceMessage: String
)

@Serializable
data class FeatureFlag(
    @SerialName("id") val id: String,
    @SerialName("name") val name: String,
    @SerialName("description") val description: String,
    @SerialName("enabled") val enabled: Boolean
)

@Serializable
data class RemoteVariables(
    @SerialName("welcome_message") val welcomeMessage: String,
    @SerialName("max_items_per_page") val maxItemsPerPage: Int,
    @SerialName("cache_duration_hours") val cacheDurationHours: Int,
    @SerialName("api_endpoint") val apiEndpoint: String
)

