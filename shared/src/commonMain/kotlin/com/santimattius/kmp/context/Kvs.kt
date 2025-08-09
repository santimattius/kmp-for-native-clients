package com.santimattius.kmp.context

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

interface Kvs {

    suspend fun write(key: String, value: String)

    fun read(key: String, defaultValue: String): Flow<String>
}

internal class DataStoreKvs(
    private val dataStore: DataStore<Preferences>,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : Kvs {

    override suspend fun write(key: String, value: String): Unit =
        withContext(coroutineDispatcher) {
            dataStore.edit { preferences ->
                preferences[stringPreferencesKey(key)] = value
            }
        }

    override fun read(
        key: String,
        defaultValue: String
    ): Flow<String> {
        return dataStore.data.map { preferences ->
            preferences[stringPreferencesKey(key)] ?: defaultValue
        }
    }
}