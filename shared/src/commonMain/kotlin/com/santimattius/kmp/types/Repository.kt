package com.santimattius.kmp.types

import kotlinx.coroutines.delay

class Repository<T> {

    private var items: MutableList<T> = mutableListOf()


    suspend fun set(value: T) {
        delay(1000)
        items.add(value)
    }

    suspend fun get(): T? {
        delay(1000)
        return items.firstOrNull()
    }
}