package com.santimattius.kmp.types

data class Location(
    val latitude: Double,
    val longitude: Double,
)

interface LocationRepository {
    suspend fun getCurrentLocation(): Result<Location>
    suspend fun updateLocation(location: Location): Result<Unit>
    suspend fun getLastLocation(): Status
}