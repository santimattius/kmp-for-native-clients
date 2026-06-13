package com.santimattius.kmp.di

import org.koin.core.context.startKoin

internal object KoinRuntime {
    fun init() {
        startKoin {
            modules(sharedModules)
        }
    }
}
