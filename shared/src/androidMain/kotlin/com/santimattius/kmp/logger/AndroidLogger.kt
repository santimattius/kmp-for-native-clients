package com.santimattius.kmp.logger

import android.content.Context
import android.util.Log

class AndroidLogger(private val context: Context) : Logger {

    override fun logException(exception: TrackableException) {
        Log.e(TAG, "${context.packageName}:" + exception.message, exception)
    }

    companion object {
        private const val TAG = "AndroidLogger"
    }
}