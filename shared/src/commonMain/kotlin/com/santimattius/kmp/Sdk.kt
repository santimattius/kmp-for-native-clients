package com.santimattius.kmp

import com.santimattius.kmp.logger.Logger

expect object Sdk {
    suspend fun writeKvs(key: String, value: String)
    val logger: Logger
}
