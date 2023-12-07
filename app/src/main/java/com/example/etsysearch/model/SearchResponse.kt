package com.example.etsysearch.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResponse(

    @Json(name = "count") var count: Long,
    @Json(name = "results") var results: List<Result?>?,
    @Json(name = "type") var type: String?,
    @Json(name = "pagination") var pagination: Pagination?,
)
