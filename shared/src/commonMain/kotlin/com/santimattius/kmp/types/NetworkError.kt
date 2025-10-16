package com.santimattius.kmp.types

import com.santimattius.kmp.concurrency.User

class NetworkError(message: String) : Exception(message)

interface ProfileService {

    @Throws(NetworkError::class)
    fun fetchProfile(id: Long): User
}

class ProfileServiceImpl : ProfileService {
    @Throws(NetworkError::class)
    override fun fetchProfile(id: Long): User {
        return User("Santiago", "Mattiauda")

    }
}