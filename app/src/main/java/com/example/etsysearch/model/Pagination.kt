package com.example.etsysearch.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Pagination(
    @Json(name = "effective_limit") var effectiveLimit: Int?,
    @Json(name = "effective_offset") var effectiveOffset: Int?,
    @Json(name = "next_offset") var nextOffset: Int?,
    @Json(name = "effective_page") var effectivePage: Int?,
    @Json(name = "next_page") var nextPage: Int?
) : Parcelable
