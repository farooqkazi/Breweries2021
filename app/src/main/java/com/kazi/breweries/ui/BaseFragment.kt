package com.kazi.breweries.ui

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.kazi.breweries.R

open class BaseFragment : Fragment() {
    fun setupToolbar(@StringRes title: Int = R.string.empty_string, backButton: Boolean = false) {
        (context as BaseActivity).supportActionBar?.title = getString(title)
        (context as BaseActivity).supportActionBar?.setHomeButtonEnabled(backButton)
        (context as BaseActivity).supportActionBar?.setDisplayHomeAsUpEnabled(backButton)
    }
}