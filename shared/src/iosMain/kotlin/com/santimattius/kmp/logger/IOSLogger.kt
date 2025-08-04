package com.santimattius.kmp.logger

import platform.Foundation.NSLog

class IOSLogger : Logger {
    override fun logException(exception: TrackableException) {
        NSLog("Exception occurred: $exception")
    }
}