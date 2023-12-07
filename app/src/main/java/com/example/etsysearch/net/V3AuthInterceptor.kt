package com.example.etsysearch.net

import com.example.etsysearch.config.Config
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class V3AuthInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        // Add the header params
        builder.addHeader(Config.HEADER_X_APIKEY, Config.API_KEY)
        builder.addHeader("Accept-Encoding", "identity")
        return chain.proceed(builder.build())
    }

}

