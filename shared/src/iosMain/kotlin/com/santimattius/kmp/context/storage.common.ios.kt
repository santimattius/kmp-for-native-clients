package com.santimattius.kmp.context

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.santimattius.kmp.storage.createDataStore

actual fun getDataStore(context: PlatformContext): DataStore<Preferences> {
    return createDataStore()
}

actual class DataStoreFactory {
    actual fun create(): DataStore<Preferences> {
        return createDataStore()
    }
}