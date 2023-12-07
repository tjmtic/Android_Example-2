package com.example.etsysearch.net

import androidx.annotation.StringRes
import com.example.etsysearch.R

/**
 * Exception indicating a quick check via the connectivity manager showed the devices was offline
 * Thrown by repo classes to tell the view to show an error state
 */
class NetworkUnavailableException : Exception {
    @StringRes
    var errorStringId = R.string.error_no_internet
        private set

    constructor() : super() {}
    constructor(detailMessage: String?) : super(detailMessage) {}
    constructor(detailMessage: String?, throwable: Throwable?) : super(detailMessage, throwable) {}
    constructor(throwable: Throwable?) : super(throwable) {}

    /**
     * Set an Android string resource id for this exception that can be shown to the user
     *
     *
     * Defaults to R.string.error_no_internet if this method is not called.
     */
    fun withStringId(@StringRes errorStringId: Int): Throwable {
        this.errorStringId = errorStringId
        return this
    }
}
