package com.santimattius.kmp

import com.santimattius.kmp.context.DataStoreKvs
import com.santimattius.kmp.logger.Logger
import com.santimattius.kmp.storage.getDataStore
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

actual object Sdk {

    private val koinComponent = object : KoinComponent {
        val logger: Logger by inject()
    }

    actual val logger: Logger
        get() = koinComponent.logger

    actual suspend fun writeKvs(key: String, value: String) =
        DataStoreKvs(dataStore = getDataStore()).write(key, value)
}
