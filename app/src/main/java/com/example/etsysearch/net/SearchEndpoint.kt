package com.example.etsysearch.net

import com.example.etsysearch.model.SearchResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit 2 endpoint definition
 */
interface SearchEndpoint {
    @GET("v3/application/listings/active")
    fun search(
        @Query("keywords") keywords: String,
        @Query("offset") offset: Int? = null,
        @Query("limit") limit: Int? = null,
    ): Observable<SearchResponse>
}
