package com.kazi.breweries.business.home.repository

import com.kazi.breweries.business.common.dto.Brewery
import com.kazi.breweries.core.network.BreweriesApi
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class HomeRepositoryTest {
    private lateinit var mRepository: HomeRepository
    private var mApi: BreweriesApi = mock(BreweriesApi::class.java)

    @Before
    fun setup() {
        mRepository = HomeRepository(mApi)
    }

    @Test
    fun getBreweries() {
        val mList = mutableListOf(Brewery())
        `when`(mApi.getBreweries()).thenReturn(Single.just(mList))

        mRepository.getBreweries().test().assertComplete()
        mRepository.getBreweries().test().assertSubscribed()
    }
}