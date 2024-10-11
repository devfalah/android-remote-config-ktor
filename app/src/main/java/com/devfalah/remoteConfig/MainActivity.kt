package com.devfalah.remoteConfig

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.devfalah.remoteConfig.ui.screens.remoteConfig.RemoteConfigScreen
import com.devfalah.remoteConfig.ui.theme.RemoteConfigTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RemoteConfigTheme {
                RemoteConfigScreen()
            }
        }
    }
}


