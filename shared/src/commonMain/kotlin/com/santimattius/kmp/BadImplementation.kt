package com.santimattius.kmp

@Target(AnnotationTarget.TYPEALIAS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
@RequiresOptIn(level = RequiresOptIn.Level.ERROR)
annotation class BadImplementation