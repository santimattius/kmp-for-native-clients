package com.santimattius.kmp.concurrency

import com.santimattius.kmp.concurrency.model.CharacterResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

internal class DragonBallRepository(
    private val client: HttpClient,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun getCharacters(): List<Character> = withContext(dispatcher) {
        client.get("/api/characters")
            .body<CharacterResponse>().items.map {
                Character(
                    id = it.id,
                    name = it.name,
                    image = it.image,
                    description = it.description,
                )
            }
    }

    suspend fun randomCharacter(): Character = withContext(dispatcher) {
        getCharacters().random()
    }

}