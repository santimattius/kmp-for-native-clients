package com.santimattius.kmp.concurrency

import com.santimattius.kmp.Platform
import com.santimattius.kmp.getPlatform
import kotlinx.coroutines.delay

class PlatformRepository {
    suspend fun getPlatform(): Platform {
        delay(1000)
        return getPlatform()
    }
}