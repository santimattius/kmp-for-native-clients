package com.santimattius.kmp.context

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.santimattius.kmp.BadImplementation

@BadImplementation
expect fun getDataStore(context: PlatformContext): DataStore<Preferences>


expect class DataStoreFactory{
    fun create():DataStore<Preferences>
}
