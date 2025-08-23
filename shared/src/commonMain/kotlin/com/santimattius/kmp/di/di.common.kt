package com.santimattius.kmp.di

import com.santimattius.kmp.concurrency.DragonBallRepository
import com.santimattius.kmp.concurrency.NumberFlowRepository
import com.santimattius.kmp.concurrency.UserRepository
import com.santimattius.kmp.concurrency.client.BASE_URL
import com.santimattius.kmp.concurrency.client.ktorHttpClient
import io.ktor.client.HttpClient
import org.koin.core.module.Module
import org.koin.dsl.module

expect val platformModule: Module


private val commonModule = module {
    single<HttpClient> { ktorHttpClient(baseUrl = BASE_URL) }
    single<DragonBallRepository> { DragonBallRepository(get()) }
    single<UserRepository> { UserRepository() }
    single<NumberFlowRepository> { NumberFlowRepository() }
}

val sharedModules = listOf(commonModule, platformModule)

