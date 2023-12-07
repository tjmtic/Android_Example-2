package com.example.etsysearch.searchresults

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.etsysearch.EtsySearchApplication
import com.example.etsysearch.MainActivity
import com.example.etsysearch.R
import com.example.etsysearch.repositories.SearchRepo
import com.example.etsysearch.searchresults.SearchResultsAdapter.LoadListener
import javax.inject.Inject

class SearchResultsActivity : AppCompatActivity() {

    @Inject
    lateinit var searchRepo: SearchRepo


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EtsySearchApplication.appComponent?.inject(this)
        setContentView(R.layout.activity_results)
        val resultsView = findViewById<RecyclerView>(R.id.results_view)
        resultsView.layoutManager = GridLayoutManager(this, 2)
        val searchTerms = intent.getStringExtra(MainActivity.SEARCH_TERMS)
        val adapter = SearchResultsAdapter(
            searchTerms ?: "",
            searchRepo,
            object : LoadListener {
                override fun onLoadError(throwable: Throwable?) {}
                override fun onInitialLoadDone() {}
            })
        resultsView.adapter = adapter
    }
}
