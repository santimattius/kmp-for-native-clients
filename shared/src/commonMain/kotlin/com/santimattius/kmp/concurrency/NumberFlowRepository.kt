package com.santimattius.kmp.concurrency

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.time.Duration.Companion.seconds

class NumberFlowRepository {
    fun getNumbers(): Flow<Int> = flow {
        for (i in 1..10) {
            emit(i)
            delay(1.seconds)
        }
    }
}