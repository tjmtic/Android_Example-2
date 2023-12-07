package com.example.etsysearch.dagger

import android.content.Context
import com.example.etsysearch.MainActivity
import com.example.etsysearch.searchresults.SearchResultsActivity
import com.squareup.moshi.Moshi
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(t: MainActivity?)
    fun inject(searchResultsActivity: SearchResultsActivity?)
    fun context(): Context?
    fun moshi(): Moshi
}
