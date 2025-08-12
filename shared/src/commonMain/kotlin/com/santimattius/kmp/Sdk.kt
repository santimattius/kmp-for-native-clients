package com.santimattius.kmp

//import com.santimattius.kmp.context.DataStoreFactory
import com.santimattius.kmp.context.DataStoreKvs
import com.santimattius.kmp.context.Kvs
import com.santimattius.kmp.logger.Logger
import com.santimattius.kmp.storage.getDataStore
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object Sdk : KoinComponent {
    //private lateinit var _logger: Logger
    private val _logger: Logger by inject()

    val logger: Logger
        get() = _logger

    ///private lateinit var dataStoreFactory: DataStoreFactory

    fun registerLogger(logger: Logger) {
        //this._logger = logger
        loadKoinModules(module = module {
            single<Logger> { logger }
        })

    }

    /*fun registerDataStoreFactory(dataStoreFactory: DataStoreFactory) {
        this.dataStoreFactory = dataStoreFactory
    }*/

    //fun getKvs(): Kvs = DataStoreKvs(dataStoreFactory.create())
    fun getKvs(): Kvs = DataStoreKvs(dataStore = getDataStore())

}