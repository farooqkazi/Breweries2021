package com.kazi.breweries.business.home.repository

import com.kazi.breweries.db.BreweriesDatabase
import com.kazi.breweries.db.BreweryEntity

class HomeLocalRepository(private val database: BreweriesDatabase) {

    fun insertAll(breweryEntity: List<BreweryEntity>) {
        database.breweryDao().deleteAll()
        database.breweryDao().insertBreweries(breweryEntity)
    }

    fun getLocalBreweries() = database.breweryDao().getAll()
}