package com.santimattius.kmp.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.santimattius.kmp.context.getApplicationContext


actual fun getDataStore(): DataStore<Preferences> {
    return createDataStore(context = getApplicationContext())
}

private fun createDataStore(context: Context): DataStore<Preferences> = createDataStore(
    producePath = { context.filesDir.resolve(dataStoreFileName).absolutePath }
)