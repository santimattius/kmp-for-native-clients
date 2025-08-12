package com.santimattius.kmp.prefereces

import com.santimattius.kmp.preferences.KSharedPreferences
import platform.Foundation.NSUserDefaults

/**
 * iOS specific implementation of [KSharedPreferences].
 * This class provides a way to store and retrieve key-value pairs using iOS's NSUserDefaults.
 */
class IOSPreferences : KSharedPreferences {

    private val userDefaults = NSUserDefaults.standardUserDefaults

    /**
     * Retrieves all key-value pairs stored in NSUserDefaults.
     * Filters out null keys or values before returning the map.
     *
     * @return A map containing all stored preferences.
     */
    override val all: Map<String, Any>
        get() = userDefaults.dictionaryRepresentation()
            .filter { it.key != null && it.value != null }
            .map { it.key.toString() to it.value!! }.toMap()

    /**
     * Retrieves a String value from NSUserDefaults.
     *
     * @param key The name of the preference to retrieve.
     * @param defValue The default value to return if the preference does not exist.
     * @return The preference value if it exists, or defValue.
     */
    override fun getString(key: String, defValue: String): String {
        return userDefaults.stringForKey(key) ?: defValue
    }

    /**
     * Retrieves an Int value from NSUserDefaults.
     * Note: NSUserDefaults stores numbers as NSNumber, so conversion to Int is needed.
     *
     * @param key The name of the preference to retrieve.
     * @param defValue The default value to return if the preference does not exist.
     * @return The preference value if it exists, or defValue.
     */
    override fun getInt(key: String, defValue: Int): Int {
        // NSUserDefaults.integerForKey returns Long, so we need to cast to Int.
        // It's important to be mindful of potential overflow if the stored Long is outside Int range,
        // though for typical preference usage, this should be fine.
        val value = userDefaults.integerForKey(key)
        return if (value == 0L && !contains(key)) defValue else value.toInt()
    }

    /**
     * Retrieves a Long value from NSUserDefaults.
     *
     * @param key The name of the preference to retrieve.
     * @param defValue The default value to return if the preference does not exist.
     * @return The preference value if it exists, or defValue.
     */
    override fun getLong(key: String, defValue: Long): Long {
        // NSUserDefaults.integerForKey returns a Long in Kotlin/Native
        val value = userDefaults.integerForKey(key)
        // Check if the key exists because integerForKey might return 0 if the key doesn't exist.
        return if (value == 0L && !contains(key)) defValue else value
    }

    /**
     * Retrieves a Float value from NSUserDefaults.
     *
     * @param key The name of the preference to retrieve.
     * @param defValue The default value to return if the preference does not exist.
     * @return The preference value if it exists, or defValue.
     */
    override fun getFloat(key: String, defValue: Float): Float {
        // NSUserDefaults.floatForKey returns a Float directly.
        val value = userDefaults.floatForKey(key)
        return if (value == 0.0f && !contains(key)) defValue else value
    }

    /**
     * Retrieves a Boolean value from NSUserDefaults.
     *
     * @param key The name of the preference to retrieve.
     * @param defValue The default value to return if the preference does not exist.
     * @return The preference value if it exists, or defValue.
     */
    override fun getBoolean(key: String, defValue: Boolean): Boolean {
        // NSUserDefaults.boolForKey returns a Boolean.
        // It returns false if the key doesn't exist. So, check if the key exists for accurate default value retrieval.
        return if (!contains(key)) defValue else userDefaults.boolForKey(key)
    }

    /**
     * Creates a new [KSharedPreferences.KEditor] for modifying NSUserDefaults.
     *
     * @return A new [IOSEditor] instance.
     */
    override fun edit(): KSharedPreferences.KEditor {
        return IOSEditor(userDefaults)
    }

    /**
     * Checks if NSUserDefaults contains a preference with the given key.
     *
     * @param key The key to check.
     * @return True if the key exists, false otherwise.
     */
    override fun contains(key: String): Boolean {
        return userDefaults.objectForKey(key) != null
    }
}
