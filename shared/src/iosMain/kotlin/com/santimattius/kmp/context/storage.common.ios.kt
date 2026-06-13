package com.santimattius.kmp.context

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.santimattius.kmp.storage.createDataStore

internal actual fun getDataStore(context: PlatformContext): DataStore<Preferences> {
    return createDataStore()
}

internal actual class DataStoreFactory {
    actual fun create(): DataStore<Preferences> {
        return createDataStore()
    }
}