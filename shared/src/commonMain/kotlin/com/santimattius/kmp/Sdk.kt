package com.santimattius.kmp

import com.santimattius.kmp.logger.Logger

object Sdk {

    private lateinit var _logger: Logger
    val logger: Logger
        get() = _logger

    fun registerLogger(logger: Logger) {
        this._logger = logger
    }


}