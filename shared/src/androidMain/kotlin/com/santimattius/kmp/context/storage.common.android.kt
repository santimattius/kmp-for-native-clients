package com.santimattius.kmp.context

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.santimattius.kmp.storage.createDataStore

actual fun getDataStore(context: PlatformContext): DataStore<Preferences> {
    return createDataStore(context.context)
}

actual class DataStoreFactory(private val context: Context) {
    init {
        require(!context.canLeakMemory()) { "The passed $context would leak memory!" }
    }

    actual fun create(): DataStore<Preferences> {
        return createDataStore(context)
    }
}