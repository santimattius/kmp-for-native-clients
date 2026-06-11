package com.santimattius.kmp.di

import com.santimattius.kmp.concurrency.NumberFlowRepository
import com.santimattius.kmp.concurrency.PlatformRepository
import com.santimattius.kmp.concurrency.UserRepository
import com.santimattius.kmp.logger.Logger
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin


object KoinContainer : KoinComponent {

    private val _logger: Logger by inject()
    private val _userRepository: UserRepository by inject()
    private val _numberFlowRepository: NumberFlowRepository by inject()
    private val _platformRepository: PlatformRepository by inject()

    fun start() {
        startKoin {
            modules(sharedModules)
        }
    }

    fun getLogger() = _logger

    fun getUserRepository() = _userRepository

    fun getNumberFlowRepository() = _numberFlowRepository

    fun getPlatformRepository() = _platformRepository
}