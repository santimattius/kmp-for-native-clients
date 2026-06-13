package com.santimattius.kmp.di

import com.santimattius.kmp.logger.AndroidLogger
import com.santimattius.kmp.logger.Logger
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual val platformModule: Module = module {
    single<Logger> {
        AndroidLogger(context = androidContext())
    }
}