package com.example.etsysearch.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class MainImage(
    /*
    EXAMPLE DATA
    url_75x75: "https://img0.etsystatic.com/109/0/13576222/il_75x75.1037185696_5kyt.jpg",
    url_170x135: "https://img0.etsystatic.com/109/0/13576222/il_170x135.1037185696_5kyt.jpg",
    url_570xN: "https://img0.etsystatic.com/109/0/13576222/il_570xN.1037185696_5kyt.jpg",
    url_fullxfull: "https://img0.etsystatic.com/109/0/13576222/il_fullxfull.1037185696_5kyt.jpg"
     */
    @Json(name = "url_75x75") var url75x75: String?,
    @Json(name = "url_170x135") var url170x135: String?,
    @Json(name = "url_570xN") var url570xN: String?,
    @Json(name = "url_fullxfull") var urlfullxfull: String?,
) : Parcelable
