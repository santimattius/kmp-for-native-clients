package com.santimattius.kmp.concurrency

import kotlinx.coroutines.delay
import kotlin.random.Random

class UserRepository {

    suspend fun fetchUserData(): User {
        delay(1000)
        return User("Santiago", "Mattiauda")
    }

    @Throws(IllegalStateException::class)
    suspend fun randomUserData(): User {
        if (networkAvailable()) {
            delay(1000)
            return User("Santiago", "Mattiauda")
        } else {
            throw IllegalStateException("No network available")
        }
    }

    private fun networkAvailable(): Boolean {
        return Random.nextBoolean()
    }

}