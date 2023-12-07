package com.example.etsysearch.searchresults

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.etsysearch.R
import com.example.etsysearch.model.Pagination
import com.example.etsysearch.model.Result
import com.example.etsysearch.model.SearchResponse
import com.example.etsysearch.net.NoResultsException
import com.example.etsysearch.repositories.SearchRepo
import com.example.etsysearch.repositories.specs.SearchSpec
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.*

class SearchResultsAdapter(
    private val searchTerms: String,
    private val searchRepo: SearchRepo,
    private var loadListener: LoadListener?
) : RecyclerView.Adapter<ViewHolder>() {
    private var currentPage: Pagination? = null
    private var currentSpec: SearchSpec? = null
    private val items: MutableList<Result?>
    private var isLoading = false
    private var doneNotificationSent = false

    /**
     * {@inheritDoc}
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.search_result, parent, false)
        return SearchResultsViewHolder(view)
    }

    /**
     * {@inheritDoc}
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        items[position]?.let { (holder as SearchResultsViewHolder).bind(it) }
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Optional load listener you can use if you want
    ////////////////////////////////////////////////////////////////////////////////
    interface LoadListener {
        fun onLoadError(throwable: Throwable?)

        /**
         * Will only be called once, after the initial load
         */
        fun onInitialLoadDone()
    }

    ////////////////////////////////////////////////////////////////////////////////
    // code below loads the listing from Etsy's search API,
    // feel free to change this only if you want
    ////////////////////////////////////////////////////////////////////////////////
    private fun loadFirstPage() {
        val spec = SearchSpec(
            keywords = searchTerms,
            includes = "MainImage",
            offset = 0,
            limit = 25
        )
        loadPage(spec)
    }

    /**
     * {@inheritDoc}
     */
    override fun getItemCount(): Int {
        return items.size
    }

    private fun loadPage(spec: SearchSpec) {
        isLoading = true
        searchRepo.get(spec)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { searchResponse: SearchResponse ->
                    Timber.v("Response %d", searchResponse.count)
                    handleResponse(searchResponse, spec)
                }
            ) { throwable: Throwable ->
                isLoading = false
                showError(throwable)
            }
    }

    private fun handleResponse(searchResponse: SearchResponse, spec: SearchSpec) {
        isLoading = false
        if (searchResponse.results.isNullOrEmpty()) {
            //show no results error
            showError(NoResultsException().withStringId(R.string.error_no_results))
        } else {
            items.addAll(searchResponse.results!!)
            currentPage = searchResponse.pagination
            currentSpec = spec
            notifyDataSetChanged()
            notifyDone()
        }
    }

    private fun showError(throwable: Throwable) {
        Timber.e(throwable, "error loading search result")
        if (loadListener != null) {
            loadListener!!.onLoadError(throwable)
        }
    }

    private fun notifyDone() {
        if (!doneNotificationSent && loadListener != null) {
            loadListener!!.onInitialLoadDone()
            doneNotificationSent = true
        }
    }

    fun clearListener() {
        loadListener = null
    }

    init {
        items = ArrayList()
        loadFirstPage()
    }
}
