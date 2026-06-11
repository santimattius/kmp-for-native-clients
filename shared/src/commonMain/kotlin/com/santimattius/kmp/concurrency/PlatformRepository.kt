package com.santimattius.kmp.concurrency

import com.santimattius.kmp.Platform

open class PlatformRepository {
    open suspend fun getPlatform(): Platform = com.santimattius.kmp.getPlatform()
}