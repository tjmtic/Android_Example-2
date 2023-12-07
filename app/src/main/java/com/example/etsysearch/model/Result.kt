package com.example.etsysearch.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Result(
    @Json(name = "listing_id") var id: String,
    @Json(name = "listing_title") var title: String,
    @Json(name = "description") var description: String?,
    @Json(name = "MainImage") var mainImage: MainImage?,
) : Parcelable
