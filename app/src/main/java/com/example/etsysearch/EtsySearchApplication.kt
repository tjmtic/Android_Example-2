package com.example.etsysearch

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import com.example.etsysearch.dagger.AppComponent
import com.example.etsysearch.dagger.AppModule
import com.example.etsysearch.dagger.DaggerAppComponent
import timber.log.Timber

/**
 * Custom application class, be sure this is defined in the manifest
 * Configures app-wide dependencies like dagger, fonts, Timber
 */
class EtsySearchApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(applicationContext))
            .build()
    }

    companion object {
        var appComponent: AppComponent? = null
    }
}
