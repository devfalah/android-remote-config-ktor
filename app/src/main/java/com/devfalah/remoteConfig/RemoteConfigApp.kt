package com.devfalah.remoteConfig

import android.app.Application
import com.devfalah.remoteConfig.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RemoteConfigApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@RemoteConfigApp)
            modules(appModule)
        }
    }
}
