package com.santimattius.kmp

//import com.santimattius.kmp.context.DataStoreFactory
import com.santimattius.kmp.context.DataStoreKvs
import com.santimattius.kmp.context.Kvs
import com.santimattius.kmp.logger.Logger
import com.santimattius.kmp.storage.getDataStore

object Sdk {
    private lateinit var _logger: Logger
    val logger: Logger
        get() = _logger

    ///private lateinit var dataStoreFactory: DataStoreFactory

    fun registerLogger(logger: Logger) {
        this._logger = logger
    }

    /*fun registerDataStoreFactory(dataStoreFactory: DataStoreFactory) {
        this.dataStoreFactory = dataStoreFactory
    }*/

    //fun getKvs(): Kvs = DataStoreKvs(dataStoreFactory.create())
    fun getKvs(): Kvs = DataStoreKvs(dataStore = getDataStore())

}