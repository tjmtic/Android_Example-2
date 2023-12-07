package com.example.etsysearch.dagger

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.preference.PreferenceManager
import com.example.etsysearch.config.Config
import com.example.etsysearch.net.*
import com.example.etsysearch.repositories.SearchRepo
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Provides the app-wide dependencies to be injected
 */
@Module
class AppModule(context: Context) {
    private val context: Context = context.applicationContext

    @Provides
    @Singleton
    fun provideContext(): Context {
        return context
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    @Provides
    @Singleton
    fun provideConnectivityManager(context: Context): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    @Provides
    @Singleton
    fun provideNetworkStatus(
        connectivityManager: ConnectivityManager,
        context: Context
    ): NetworkStatus {
        return NetworkStatus(connectivityManager, context)
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        configuredOkhttp: ConfiguredOkhttp,
        moshiConverterFactory: MoshiConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Config.API_URL)
            .addConverterFactory(moshiConverterFactory)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(configuredOkhttp.get())
            .build()
    }

    @Provides
    @Singleton
    fun provideHttpLogger(): HttpLogger {
        return HttpLogger()
    }

    @Singleton
    @Provides
    fun provideMoshiConverter(moshi: Moshi): MoshiConverterFactory {
        return MoshiConverterFactory.create(moshi)
    }

    @Provides
    @Singleton
    fun provideConfiguredOkhttp(
        httpLogger: HttpLogger,
        cacheProvider: CacheProvider,
        v3AuthInterceptor: V3AuthInterceptor,
    ): ConfiguredOkhttp {
        return ConfiguredOkhttp(
            httpLogger = httpLogger,
            cacheProvider = cacheProvider,
            authInterceptor = v3AuthInterceptor,
        )
    }

    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideSearchRepo(
        retrofit: Retrofit,
        networkStatus: NetworkStatus,
        sampleJson: SampleJson,
    ): SearchRepo {
        return SearchRepo(retrofit, networkStatus, sampleJson)
    }

    @Provides
    @Singleton
    fun provideCacheProvider(context: Context): CacheProvider {
        return CacheProvider(context)
    }

}
