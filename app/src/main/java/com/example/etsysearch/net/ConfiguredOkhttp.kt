package com.example.etsysearch.net

import okhttp3.OkHttpClient
import javax.inject.Inject

/**
 * Provides OkHttp with user agent and logging configured (and auth possibly in the future)
 */
class ConfiguredOkhttp @Inject constructor(
    httpLogger: HttpLogger,
    cacheProvider: CacheProvider,
    authInterceptor: V3AuthInterceptor,
) {
    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(httpLogger.get())
        .addInterceptor(authInterceptor)
        .cache(cacheProvider.get())
        .retryOnConnectionFailure(true)
        .build()

    fun get(): OkHttpClient {
        return client
    }

}
