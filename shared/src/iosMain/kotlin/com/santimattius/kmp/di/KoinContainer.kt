package com.santimattius.kmp.di

import com.santimattius.kmp.logger.Logger
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin


object KoinContainer : KoinComponent {

    private val _logger: Logger by inject()

    fun start() {
        startKoin {
            modules(platformModule)
        }
    }

    fun getLogger() = _logger
}