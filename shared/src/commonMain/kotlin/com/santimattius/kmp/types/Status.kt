package com.santimattius.kmp.types

sealed class Status {
    data class Error(val message: String) : Status()
    data class Success(val result: Location) : Status()
}
