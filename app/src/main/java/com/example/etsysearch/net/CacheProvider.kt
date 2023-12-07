package com.example.etsysearch.net

import android.content.Context
import okhttp3.Cache
import timber.log.Timber
import java.io.File
import java.io.IOException
import javax.inject.Inject

/**
 * Singleton to enable access to the cache form the http stack as well as the debug menu
 */
class CacheProvider @Inject constructor(context: Context) {
    private val context: Context
    private var cache: Cache? = null
    fun get(): Cache? {
        if (cache == null) {
            cache = create()
        }
        return cache
    }

    private fun create(): Cache? {
        var newCache: Cache? = null
        try {
            newCache = Cache(
                File(context.cacheDir, "http-cache"),
                10L * 1024L * 1024L
            ) // 10 MB
        } catch (e: Exception) {
            Timber.e(e, "Could not create Cache!")
        }
        return newCache
    }

    fun clear() {
        try {
            cache!!.evictAll()
        } catch (e: IOException) {
            Timber.e(e, "Error clearing cache")
        }
    }

    init {
        this.context = context.applicationContext
    }
}
