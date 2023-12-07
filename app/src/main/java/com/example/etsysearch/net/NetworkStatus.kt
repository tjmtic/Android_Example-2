package com.example.etsysearch.net

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.Network
import android.net.NetworkRequest
import android.os.Build
import javax.inject.Inject

/**
 * Simple check to see if the user is online,
 * this can be made much more robust via 'ConnectivityManager.NetworkCallback'
 * and BroadcastReceivers
 */
class NetworkStatus @Inject constructor(
    private val connectivityManager: ConnectivityManager,
    private val context: Context
) {
    fun connected(): Boolean {
        val activeNetwork = connectivityManager.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    fun registerConnectivityActionLollipop() {
        val builder = NetworkRequest.Builder()
        connectivityManager
            .registerNetworkCallback(builder.build(), object : NetworkCallback() {
                override fun onAvailable(network: Network) {
                    val intent = Intent(CONNECTIVITY_ACTION_LOLLIPOP)
                    intent.putExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false)
                    context.sendBroadcast(intent)
                }

                override fun onLost(network: Network) {
                    val intent = Intent(CONNECTIVITY_ACTION_LOLLIPOP)
                    intent.putExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, true)
                    context.sendBroadcast(intent)
                }
            })
    }

    companion object {
        /**
         * Lollipop has a different string for connection type
         */
        private const val CONNECTIVITY_ACTION_LOLLIPOP =
            "com.example.etsysearch.net.CONNECTIVITY_ACTION_LOLLIPOP"
    }
}
