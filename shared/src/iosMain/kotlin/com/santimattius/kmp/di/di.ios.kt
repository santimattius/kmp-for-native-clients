package com.santimattius.kmp.di

import com.santimattius.kmp.concurrency.PlatformRepository
import com.santimattius.kmp.logger.IOSLogger
import com.santimattius.kmp.logger.Logger
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual val platformModule: Module = module {
    single<Logger> {
        IOSLogger()
    }
    single { PlatformRepository() }
}