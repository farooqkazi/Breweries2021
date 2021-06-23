package com.kazi.breweries.business.home.repository

import com.kazi.breweries.core.network.BreweriesApi

/**
 * Repository class to get data from server.
 */
open class HomeRepository(private val api: BreweriesApi) {

    fun getBreweries() = api.getBreweries()

}