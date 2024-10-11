package com.devfalah.remoteConfig.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

class RemoteConfigManager(
    private val client: HttpClient,
) {
    suspend fun fetchConfig(): RemoteConfig {
        val response = client.get("https://api.github.com/gists/9bfd31821554c97650a2850361f99d77")
        val gistResponse: GistResponse = response.body()
        val remoteConfigJson = gistResponse.files["remote_config.json"]?.content
            ?: throw IllegalStateException("Remote config not found")
        return Json.decodeFromString(RemoteConfig.serializer(), remoteConfigJson)
    }
}

@Serializable
data class GistResponse(val files: Map<String, GistFile>)

@Serializable
data class GistFile(val content: String)
