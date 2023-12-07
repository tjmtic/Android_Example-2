package com.example.etsysearch.searchresults

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.etsysearch.R
import com.example.etsysearch.listingdetail.ListingDetailActivity
import com.example.etsysearch.model.Result
import com.example.etsysearch.repositories.FavoritesRepo

/**
 * A ViewHolder for search results, flavored with Kotlin
 */
class SearchResultsViewHolder internal constructor(itemView: View?) : ViewHolder(
    itemView!!
) {
    fun bind(result: Result) {

        val title = itemView.findViewById<TextView>(R.id.listing_title)
        val image = itemView.findViewById<ImageView>(R.id.listing_image)
        val favButton = itemView.findViewById<ImageView>(R.id.favorite_button)

        title.text = result.title
        val url: String? = result.mainImage?.url170x135

        Glide.with(itemView.context)
            .load(url)
            .placeholder(ColorDrawable(Color.GRAY))
            .into(image)

        val favoritesRepo = FavoritesRepo(itemView.context)

        itemView.setOnClickListener {
            val detailIntent = Intent(itemView.context, ListingDetailActivity::class.java)
            itemView.context.startActivity(detailIntent)
        }
    }
}
