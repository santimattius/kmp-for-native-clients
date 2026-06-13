package com.santimattius.kmp

import com.santimattius.kmp.concurrency.NumberFlowRepository
import com.santimattius.kmp.concurrency.PlatformRepository
import com.santimattius.kmp.concurrency.UserRepository
import com.santimattius.kmp.context.DataStoreKvs
import com.santimattius.kmp.di.KoinRuntime
import com.santimattius.kmp.logger.Logger
import com.santimattius.kmp.storage.getDataStore
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

actual object Sdk {

    private val koinComponent = object : KoinComponent {
        val logger: Logger by inject()
        val userRepository: UserRepository by inject()
        val numberFlowRepository: NumberFlowRepository by inject()
        val platformRepository: PlatformRepository by inject()
    }

    fun doInit() = KoinRuntime.init()

    actual suspend fun writeKvs(key: String, value: String) =
        DataStoreKvs(dataStore = getDataStore()).write(key, value)

    actual val logger: Logger
        get() = koinComponent.logger

    fun getLogger(): Logger = koinComponent.logger

    fun getUserRepository(): UserRepository = koinComponent.userRepository

    fun getPlatformRepository(): PlatformRepository = koinComponent.platformRepository

    fun getNumberFlowRepository(): NumberFlowRepository = koinComponent.numberFlowRepository
}
