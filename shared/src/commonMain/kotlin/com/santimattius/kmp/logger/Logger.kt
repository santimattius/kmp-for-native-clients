package com.santimattius.kmp.logger

interface Logger {

    fun logException(exception: TrackableException)
}