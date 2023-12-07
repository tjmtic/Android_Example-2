package com.example.etsysearch.repositories

import com.example.etsysearch.R
import com.example.etsysearch.model.SearchResponse
import com.example.etsysearch.net.*
import com.example.etsysearch.repositories.specs.SearchSpec
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Example of the 'repository' data-layer pattern.  Provides a place to manage http, caching or any
 * other type of data access. The presenter class that uses this repo only needs to worry about the
 * RxJava observable.
 */
class SearchRepo @Inject constructor(
    private val retrofit: Retrofit,
    private val networkStatus: NetworkStatus,
    private val sampleJson: SampleJson,

) {
    fun get(spec: SearchSpec): Observable<SearchResponse> {
        if (!networkStatus.connected()) {
            return Observable.error(
                NetworkUnavailableException()
                    .withStringId(R.string.error_no_internet)
            )
        }

        return sampleJson.get();

    }
}
