package com.santimattius.kmp.context

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.santimattius.kmp.BadImplementation

@BadImplementation
internal expect fun getDataStore(context: PlatformContext): DataStore<Preferences>

internal expect class DataStoreFactory {
    fun create(): DataStore<Preferences>
}
