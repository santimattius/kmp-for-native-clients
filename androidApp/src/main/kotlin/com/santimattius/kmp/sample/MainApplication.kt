package com.santimattius.kmp.sample

import android.app.Application
import com.santimattius.kmp.Sdk
import com.santimattius.kmp.di.platformModule
//import com.santimattius.kmp.context.DataStoreFactory
import com.santimattius.kmp.logger.AndroidLogger
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

// MainApplication is entry point
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Sdk.registerLogger(AndroidLogger(this))
        //Sdk.registerDataStoreFactory(DataStoreFactory(this))
        startKoin {
            androidContext(this@MainApplication)
            modules(platformModule)
        }
    }
}