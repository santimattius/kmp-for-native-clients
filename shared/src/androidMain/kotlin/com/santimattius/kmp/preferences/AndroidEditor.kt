package com.santimattius.kmp.preferences

import android.content.SharedPreferences

/**
 * Android-specific implementation of [KSharedPreferences.KEditor].
 * This class wraps an instance of [SharedPreferences.Editor] to provide a common interface
 * for editing preferences in a Kotlin Multiplatform project.
 *
 * @property edit The underlying [SharedPreferences.Editor] instance.
 */
class AndroidEditor(
    private var edit: SharedPreferences.Editor
) : KSharedPreferences.KEditor {
    /**
     * Sets a String value in the preferences editor.
     *
     * @param key The name of the preference to modify.
     * @param value The new value for the preference.
     * @return This editor instance.
     */
    override fun putString(
        key: String,
        value: String
    ): KSharedPreferences.KEditor = apply {
        edit = edit.putString(key, value)
    }

    /**
     * Sets an Int value in the preferences editor.
     *
     * @param key The name of the preference to modify.
     * @param value The new value for the preference.
     * @return This editor instance.
     */
    override fun putInt(
        key: String,
        value: Int
    ): KSharedPreferences.KEditor = apply {
        edit = edit.putInt(key, value)
    }

    /**
     * Sets a Long value in the preferences editor.
     *
     * @param key The name of the preference to modify.
     * @param value The new value for the preference.
     * @return This editor instance.
     */
    override fun putLong(
        key: String,
        value: Long
    ): KSharedPreferences.KEditor = apply {
        edit = edit.putLong(key, value)
    }

    /**
     * Sets a Float value in the preferences editor.
     *
     * @param key The name of the preference to modify.
     * @param value The new value for the preference.
     * @return This editor instance.
     */
    override fun putFloat(
        key: String,
        value: Float
    ): KSharedPreferences.KEditor = apply {
        edit = edit.putFloat(key, value)
    }

    /**
     * Sets a Boolean value in the preferences editor.
     *
     * @param key The name of the preference to modify.
     * @param value The new value for the preference.
     * @return This editor instance.
     */
    override fun putBoolean(
        key: String,
        value: Boolean
    ): KSharedPreferences.KEditor = apply {
        edit = edit.putBoolean(key, value)
    }

    /**
     * Removes a preference value from the editor.
     *
     * @param key The name of the preference to remove.
     * @return This editor instance.
     */
    override fun remove(key: String): KSharedPreferences.KEditor = apply {
        edit = edit.remove(key)
    }

    /**
     * Removes all values from the editor.
     *
     * @return This editor instance.
     */
    override fun clear(): KSharedPreferences.KEditor = apply {
        edit = edit.clear()
    }

    /**
     * Commits the preference changes asynchronously.
     */
    override fun apply() {
        edit.apply()
    }

}
