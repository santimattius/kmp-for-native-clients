package com.santimattius.kmp.concurrency

import com.santimattius.kmp.Platform
import kotlinx.coroutines.delay

class IosPlatformRepository(
    private val platform: Platform
) : PlatformRepository() {
    override suspend fun getPlatform(): Platform {
        delay(1000)
        return platform
    }
}