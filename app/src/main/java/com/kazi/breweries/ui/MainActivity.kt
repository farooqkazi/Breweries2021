package com.kazi.breweries.ui

import android.os.Bundle
import com.kazi.breweries.R
import com.kazi.breweries.ui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment.getInstance(), HomeFragment::class.java.simpleName)
        }
        setSupportActionBar(toolbar)
    }
}
