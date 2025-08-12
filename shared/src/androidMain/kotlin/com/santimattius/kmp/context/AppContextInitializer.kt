package com.santimattius.kmp.context

import android.content.Context
import android.util.Log
import androidx.startup.Initializer

// AppContextInitializer.kt is entry point for App Startup
class AppContextInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        injectContext(context = context)
        Log.d("AppContextInitializer", "AppContextInitializer initialized")
    }

    override fun dependencies(): List<Class<out Initializer<*>?>?> {
        return emptyList()
    }
}