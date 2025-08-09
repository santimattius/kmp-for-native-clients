package com.santimattius.kmp.preferences

import android.content.Context

/**
 * Android specific implementation of [KSharedPreferences].
 * This class provides a way to store and retrieve key-value pairs using Android's SharedPreferences.
 *
 * @property context The application context, used to access SharedPreferences.
 */
class AndroidPreferences(
    context: Context
) : KSharedPreferences {

    private val sharedPreferences = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)

    /**
     * Retrieves all key-value pairs stored in SharedPreferences.
     *
     * @return A map containing all stored preferences.
     */
    override val all: Map<String, Any>
        get() = sharedPreferences.all.mapValues { it.value as Any }

    /**
     * Retrieves a String value from SharedPreferences.
     *
     * @param key The name of the preference to retrieve.
     * @param defValue The default value to return if the preference does not exist.
     * @return The preference value if it exists, or defValue.
     */
    override fun getString(key: String, defValue: String): String {
        return sharedPreferences.getString(key, defValue) ?: defValue
    }

    /**
     * Retrieves an Int value from SharedPreferences.
     *
     * @param key The name of the preference to retrieve.
     * @param defValue The default value to return if the preference does not exist.
     * @return The preference value if it exists, or defValue.
     */
    override fun getInt(key: String, defValue: Int): Int {
        return sharedPreferences.getInt(key, defValue)
    }

    /**
     * Retrieves a Long value from SharedPreferences.
     *
     * @param key The name of the preference to retrieve.
     * @param defValue The default value to return if the preference does not exist.
     * @return The preference value if it exists, or defValue.
     */
    override fun getLong(key: String, defValue: Long): Long {
        return sharedPreferences.getLong(key, defValue)
    }

    /**
     * Retrieves a Float value from SharedPreferences.
     *
     * @param key The name of the preference to retrieve.
     * @param defValue The default value to return if the preference does not exist.
     * @return The preference value if it exists, or defValue.
     */
    override fun getFloat(key: String, defValue: Float): Float {
        return sharedPreferences.getFloat(key, defValue)
    }

    /**
     * Retrieves a Boolean value from SharedPreferences.
     *
     * @param key The name of the preference to retrieve.
     * @param defValue The default value to return if the preference does not exist.
     * @return The preference value if it exists, or defValue.
     */
    override fun getBoolean(key: String, defValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defValue)
    }

    /**
     * Creates a new [KSharedPreferences.KEditor] for modifying SharedPreferences.
     *
     * @return A new [KSharedPreferences.KEditor] instance.
     */
    override fun edit(): KSharedPreferences.KEditor {
        return AndroidEditor(sharedPreferences.edit())
    }

    /**
     * Checks if SharedPreferences contains a preference with the given key.
     *
     * @param key The key to check.
     * @return True if the key exists, false otherwise.
     */
    override fun contains(key: String): Boolean {
        return sharedPreferences.contains(key)
    }
}