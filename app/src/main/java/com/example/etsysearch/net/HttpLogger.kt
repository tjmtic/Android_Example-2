package com.example.etsysearch.net

import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import javax.inject.Inject

/**
 * Simple logger for Okhttp that routes logs through Timber (so that we only log in debug, not
 * production)
 */
class HttpLogger @Inject constructor() {
    private val loggingInterceptor: HttpLoggingInterceptor
    fun get(): HttpLoggingInterceptor {
        return loggingInterceptor
    }

    init {
        val logger = HttpLoggingInterceptor.Logger { message: String? -> Timber.v(message) }
        loggingInterceptor = HttpLoggingInterceptor(logger)
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE)
    }
}
