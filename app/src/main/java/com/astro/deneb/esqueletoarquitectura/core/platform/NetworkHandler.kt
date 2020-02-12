package com.astro.deneb.esqueletoarquitectura.core.platform

import android.content.Context
import com.astro.deneb.esqueletoarquitectura.core.extensions.checkNetworkState


class NetworkHandler
(private val context: Context) {
    val isConnected get() = context.checkNetworkState()
}