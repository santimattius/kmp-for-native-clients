package com.santimattius.kmp.concurrency

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.random.Random

class UserRepository {

    suspend fun fetchUserData(): User = withContext(Dispatchers.IO){
        delay(1000)
        User("Santiago", "Mattiauda")
    }

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