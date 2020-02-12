package com.astro.deneb.esqueletoarquitectura.core.platform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.koin.android.ext.android.inject

abstract class BaseFragment: Fragment() {

    abstract fun layoutId(): Int

    private val viewModelFactory: ViewModelProvider.Factory by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(layoutId(), container, false)

}