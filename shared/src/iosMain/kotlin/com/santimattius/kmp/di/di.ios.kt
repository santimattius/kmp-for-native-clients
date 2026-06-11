package com.santimattius.kmp.di

import com.santimattius.kmp.concurrency.IosPlatformRepository
import com.santimattius.kmp.concurrency.PlatformRepository
import com.santimattius.kmp.getPlatform
import com.santimattius.kmp.logger.IOSLogger
import com.santimattius.kmp.logger.Logger
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single<Logger> {
        IOSLogger()
    }
    single { getPlatform() }
    single<PlatformRepository> { IosPlatformRepository(get())  }
}