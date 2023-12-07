package com.example.etsysearch.repositories.specs

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * This class specifies parameters to be given to the repository.
 */
@JsonClass(generateAdapter = true)
data class SearchSpec(
    @Json(name = "offset") var offset: Int?,
    @Json(name = "limit") var limit: Int?,
    @Json(name = "keywords") var keywords: String,
    @Json(name = "includes") var includes: String?,
)
