package com.example.etsysearch.net

import com.example.etsysearch.model.SearchResponse
import com.squareup.moshi.Moshi
import io.reactivex.Observable
import javax.inject.Inject

class SampleJson @Inject constructor(val moshi: Moshi) {
    private val json = """{
   "count":2,
   "results":[
      {
         "listing_id":507178979,
         "state":"active",
         "user_id":9511727,
         "category_id":68887434,
         "listing_title":"Cat bed with a matching pompom pad, dog bed, pet teepee, pet bed, pet tipi, teepee, tepee",
         "description":"This pet teepee has for walls and an entrance, decorated with pompom trim. Modern cat bed is equipped with natural wood vertical and horizontal poles. This sturdy framework ensures that the pet teepee is standing still at all times.",
         "creation_tsz":1546027392,
         "ending_tsz":1556478192,
         "original_creation_tsz":1485183099,
         "last_modified_tsz":1546027392,
         "price":"70.00",
         "currency_code":"EUR",
         "quantity":72,
         "sku":[

         ],
         "tags":[
            "pet bed",
            "petbed",
            "pet teepee",
            "pet tipi",
            "cat bed",
            "cat teepee",
            "dog bed",
            "dog teepee",
            "small dog bed",
            "pet furniture",
            "cat cave",
            "minicamp",
            "cat tipi"
         ],
         "category_path":[
            "Pets"
         ],
         "category_path_ids":[
            68887434
         ],
         "materials":[
            "wooden poles",
            "rope",
            "cotton fabric"
         ],
         "shop_section_id":22768876,
         "featured_rank":2,
         "state_tsz":1542902016,
         "url":"https:\/\/www.etsy.com\/listing\/507178979\/cat-bed-with-a-matching-pompom-pad-dog?utm_source=androidteaminterview&utm_medium=api&utm_campaign=api",
         "views":72062,
         "num_favorers":7364,
         "shipping_template_id":null,
         "processing_min":3,
         "processing_max":5,
         "who_made":"i_did",
         "is_supply":"false",
         "when_made":"made_to_order",
         "item_weight":null,
         "item_weight_unit":"g",
         "item_length":null,
         "item_width":null,
         "item_height":null,
         "item_dimensions_unit":"mm",
         "is_private":false,
         "recipient":null,
         "occasion":null,
         "style":null,
         "non_taxable":false,
         "is_customizable":true,
         "is_digital":false,
         "file_data":"",
         "should_auto_renew":true,
         "language":"en-US",
         "has_variations":true,
         "taxonomy_id":1396,
         "taxonomy_path":[
            "Pet Supplies",
            "Pet Furniture",
            "Pet Beds & Cots"
         ],
         "used_manufacturer":false,
         "MainImage":{
            "listing_image_id":1127885104,
            "hex_code":null,
            "red":null,
            "green":null,
            "blue":null,
            "hue":null,
            "saturation":null,
            "brightness":null,
            "is_black_and_white":null,
            "creation_tsz":null,
            "listing_id":507178979,
            "rank":null,
            "url_75x75":"https:\/\/i.etsystatic.com\/5831985\/c\/1000\/794\/0\/196\/il\/7bb9eb\/1127885104\/il_75x75.1127885104_r4tf.jpg",
            "url_170x135":"https:\/\/i.etsystatic.com\/5831985\/c\/1000\/794\/0\/196\/il\/7bb9eb\/1127885104\/il_170x135.1127885104_r4tf.jpg",
            "url_570xN":"https:\/\/i.etsystatic.com\/5831985\/r\/il\/7bb9eb\/1127885104\/il_570xN.1127885104_r4tf.jpg",
            "url_fullxfull":"https:\/\/i.etsystatic.com\/5831985\/r\/il\/7bb9eb\/1127885104\/il_fullxfull.1127885104_r4tf.jpg",
            "full_height":null,
            "full_width":null
         }
      },
      {
         "listing_id":639537165,
         "state":"active",
         "user_id":129504044,
         "category_id":68889702,
         "listing_title":"Blue Tie Dye Stripe Pet Fleece Tied Blanket-free toy w.purchase. Cat\/Dog blanket, Double layer fleece blanket, baby\/stroller blanket",
         "description":"Your fur-ever pal will love our super soft and snuggly double fleece tied blanket. Purr-fect to keep your pet warm and cozy while you protect your furniture and car, or use in their kennel. You&#39;ll receive a FREE kick stick catnip cat toy with your purchase!",
         "creation_tsz":1546026625,
         "ending_tsz":1556477425,
         "original_creation_tsz":1535395773,
         "last_modified_tsz":1546026625,
         "price":"20.00",
         "currency_code":"USD",
         "quantity":1,
         "sku":[
            "blanket"
         ],
         "tags":[
            "pet blanket",
            "pet bed",
            "cat bed",
            "cat blanket",
            "fleece bed",
            "fleece pet bed",
            "fleece pet blanket",
            "tie blanket",
            "dog blanket",
            "pet gift",
            "tie dye",
            "royal blue",
            "free gift"
         ],
         "category_path":[
            "Pets",
            "Blanket"
         ],
         "category_path_ids":[
            68887434,
            68889702
         ],
         "materials":[
            "fleece",
            "polyester",
            "soft bedding",
            "warm",
            "soft",
            "snuggle",
            "washable",
            "pet",
            "cat",
            "dog",
            "blanket",
            "bed",
            "gift"
         ],
         "shop_section_id":24581258,
         "featured_rank":null,
         "state_tsz":1535395773,
         "url":"https:\/\/www.etsy.com\/listing\/639537165\/blue-tie-dye-stripe-pet-fleece-tied?utm_source=androidteaminterview&utm_medium=api&utm_campaign=api",
         "views":13,
         "num_favorers":0,
         "shipping_template_id":61681963709,
         "processing_min":1,
         "processing_max":3,
         "who_made":"i_did",
         "is_supply":"false",
         "when_made":"2010_2018",
         "item_weight":"12",
         "item_weight_unit":"oz",
         "item_length":"15",
         "item_width":"10.5",
         "item_height":"4",
         "item_dimensions_unit":"in",
         "is_private":false,
         "recipient":null,
         "occasion":null,
         "style":null,
         "non_taxable":false,
         "is_customizable":false,
         "is_digital":false,
         "file_data":"",
         "should_auto_renew":true,
         "language":"en-US",
         "has_variations":true,
         "taxonomy_id":1356,
         "taxonomy_path":[
            "Pet Supplies",
            "Pet Bedding",
            "Pet Blankets"
         ],
         "used_manufacturer":false,
         "MainImage":{
            "listing_image_id":1649510607,
            "hex_code":null,
            "red":null,
            "green":null,
            "blue":null,
            "hue":null,
            "saturation":null,
            "brightness":null,
            "is_black_and_white":null,
            "creation_tsz":null,
            "listing_id":639537165,
            "rank":null,
            "url_75x75":"https:\/\/i.etsystatic.com\/18363470\/c\/2255\/1791\/85\/75\/il\/f9fa6c\/1649510607\/il_75x75.1649510607_dn7s.jpg",
            "url_170x135":"https:\/\/i.etsystatic.com\/18363470\/c\/2255\/1791\/85\/75\/il\/f9fa6c\/1649510607\/il_170x135.1649510607_dn7s.jpg",
            "url_570xN":"https:\/\/i.etsystatic.com\/18363470\/r\/il\/f9fa6c\/1649510607\/il_570xN.1649510607_dn7s.jpg",
            "url_fullxfull":"https:\/\/i.etsystatic.com\/18363470\/r\/il\/f9fa6c\/1649510607\/il_fullxfull.1649510607_dn7s.jpg",
            "full_height":null,
            "full_width":null
         }
      }
   ],
   "type":"Listing",
   "pagination":{
      "effective_limit":25,
      "effective_offset":0,
      "next_offset":25,
      "effective_page":1,
      "next_page":2
   }
}""".trimMargin()

    fun get(): Observable<SearchResponse> {
        return Observable.just(
            moshi
                .adapter(SearchResponse::class.java)
                .fromJson(json)
        )
    }
}
