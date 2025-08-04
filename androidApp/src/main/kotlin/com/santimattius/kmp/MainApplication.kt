package com.santimattius.kmp

import android.app.Application
import com.santimattius.kmp.logger.AndroidLogger

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Sdk.registerLogger(AndroidLogger(this))
    }
}