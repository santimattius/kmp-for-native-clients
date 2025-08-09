package com.santimattius.kmp.preferences

interface KSharedPreferences {
    interface KEditor {

        fun putString(key: String, value: String): KEditor

        fun putInt(key: String, value: Int): KEditor

        fun putLong(key: String, value: Long): KEditor

        fun putFloat(key: String, value: Float): KEditor

        fun putBoolean(key: String, value: Boolean): KEditor

        fun remove(key: String): KEditor

        fun clear(): KEditor

        fun apply()

    }


    val all: Map<String, Any>

    fun getString(key: String, defValue: String): String

    fun getInt(key: String, defValue: Int): Int

    fun getLong(key: String, defValue: Long): Long

    fun getFloat(key: String, defValue: Float): Float

    fun getBoolean(key: String, defValue: Boolean): Boolean

    fun edit(): KEditor

    operator fun contains(key: String): Boolean
}