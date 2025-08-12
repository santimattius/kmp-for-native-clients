package com.santimattius.kmp.context

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.santimattius.kmp.BadImplementation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

object Storage {

    private var dataStore: DataStore<Preferences>? = null
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @BadImplementation
    fun write(context: PlatformContext, key: String, value: String) {
        val preferencesKey = stringPreferencesKey(key)
        val dataStore = getOrCreate(context)
        coroutineScope.launch {
            dataStore.edit { settings ->
                settings[preferencesKey] = value
            }
        }
    }

    @BadImplementation
    fun read(context: PlatformContext, key: String, defaultValue: String): Flow<String> {
        val preferencesKey = stringPreferencesKey(key)
        val dataStore = getOrCreate(context)
        return dataStore.data.map { preferences ->
            preferences[preferencesKey] ?: defaultValue
        }
    }

    @BadImplementation
    private fun getOrCreate(context: PlatformContext): DataStore<Preferences> {
        if (dataStore == null) {
            dataStore = getDataStore(context)
        }
        return dataStore!!
    }
}