package com.example.etsysearch

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.etsysearch.searchresults.SearchResultsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EtsySearchApplication.appComponent?.inject(this)
        setContentView(R.layout.activity_main)
        val searchButton = findViewById<View>(R.id.search_button)
        val searchInput = findViewById<EditText>(R.id.search_input)
        searchButton.setOnClickListener { v: View? -> showSearchResultsScreen(searchInput.text.toString()) }
    }

    private fun showSearchResultsScreen(searchTerms: String) {
        val intent = Intent(this, SearchResultsActivity::class.java)
        intent.putExtra(SEARCH_TERMS, searchTerms)
        startActivity(intent)
    }

    companion object {
        const val SEARCH_TERMS = "search_terms"
    }
}
