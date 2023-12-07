package com.example.etsysearch.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Appears to be search request params, but echoed back in the response
 * (possibly w/ defaults replacing unset params)
 */
@JsonClass(generateAdapter = true)
data class Params(
    /* example:

      limit: 25,
      offset: 0,
      page: null,
      keywords: "asdasdasdasdasdasdasdasdasdasdfgdfgretertretertertert",
      sort_on: "created",
      sort_order: "down",
      min_price: null,
      max_price: null,
      color: null,
      color_accuracy: 0,
      tags: null,
      category: null,
      location: null,
      lat: null,
      lon: null,
      region: null,
      geo_level: "city",
      accepts_gift_cards: "false",
      translate_keywords: "false"
   */
    @Json(name = "limit") var limit: Int?,
    @Json(name = "offset") var offset: Int?,
    @Json(name = "page") var page: Int?,
    @Json(name = "keywords") var keywords: String?,
)

