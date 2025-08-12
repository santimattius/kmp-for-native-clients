package com.santimattius.kmp.prefereces

import com.santimattius.kmp.preferences.KSharedPreferences
import platform.Foundation.NSUserDefaults

/**
 * iOS specific implementation of [KSharedPreferences.KEditor].
 * This class provides a way to edit and save preferences using iOS's NSUserDefaults.
 *
 * @property userDefaults The NSUserDefaults instance to be edited.
 */
class IOSEditor(
    private var userDefaults: NSUserDefaults
) : KSharedPreferences.KEditor {

    /**
     * Sets a String value in the preferences editor.
     *
     * @param key The name of the preference to modify.
     * @param value The new value for the preference.
     * @return This editor instance, to chain calls.
     */
    override fun putString(key: String, value: String) = apply {
        userDefaults.setObject(value, key)
    }

    /**
     * Sets an Int value in the preferences editor.
     *
     * @param key The name of the preference to modify.
     * @param value The new value for the preference.
     * @return This editor instance, to chain calls.
     */
    override fun putInt(key: String, value: Int) = apply {
        userDefaults.setInteger(value.toLong(), key)
    }

    /**
     * Sets a Long value in the preferences editor.
     *
     * @param key The name of the preference to modify.
     * @param value The new value for the preference.
     * @return This editor instance, to chain calls.
     */
    override fun putLong(key: String, value: Long) = apply {
        userDefaults.setInteger(value, key)
    }

    /**
     * Sets a Float value in the preferences editor.
     *
     * @param key The name of the preference to modify.
     * @param value The new value for the preference.
     * @return This editor instance, to chain calls.
     */
    override fun putFloat(key: String, value: Float) = apply {
        userDefaults.setFloat(value, key)
    }

    /**
     * Sets a Boolean value in the preferences editor.
     *
     * @param key The name of the preference to modify.
     * @param value The new value for the preference.
     * @return This editor instance, to chain calls.
     */
    override fun putBoolean(key: String, value: Boolean) = apply {
        userDefaults.setBool(value, key)
    }

    /**
     * Removes a preference value from the editor.
     *
     * @param key The name of the preference to remove.
     * @return This editor instance, to chain calls.
     */
    override fun remove(key: String) = apply {
        userDefaults.removeObjectForKey(key)
    }

    /**
     * Removes all preference values from the editor.
     *
     * @return This editor instance, to chain calls.
     */
    override fun clear() = apply {
        userDefaults.dictionaryRepresentation().forEach {
            remove(it.key.toString())
        }
    }

    /**
     * Commits the preference changes.
     * On iOS, NSUserDefaults are saved immediately, so this method
     * throws an [UnsupportedOperationException] as explicit apply/commit is not needed
     * and not directly available in the same way as Android's SharedPreferences.Editor.
     *
     * @throws UnsupportedOperationException because apply is not available on iOS.
     */
    override fun apply() {
        // NSUserDefaults apply changes immediately.
        // No explicit apply needed, and no direct equivalent to Android's apply() which is asynchronous.
        // commit() on Android is synchronous.
        // For KMP, one might choose to make this a no-op or clarify behavior.
        // Throwing an exception if the KMP interface implies a specific commit semantic that can't be met.
        throw UnsupportedOperationException("apply is not available on iOS")
    }

}
