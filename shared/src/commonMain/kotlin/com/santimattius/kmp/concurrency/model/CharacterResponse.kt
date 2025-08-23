package com.santimattius.kmp.concurrency.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    @SerialName("items") val items: List<NetworkCharacter>,
)

@Serializable
data class NetworkCharacter(
    @SerialName("id") val id: Long,
    @SerialName("name") val name: String,
    @SerialName("ki") val ki: String,
    @SerialName("maxKi") val maxKi: String,
    @SerialName("race") val race: String,
    @SerialName("description") val description: String,
    @SerialName("image") val image: String,
)
