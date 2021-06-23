package com.kazi.breweries.ui.home

import androidx.lifecycle.MutableLiveData
import com.kazi.breweries.business.home.HomeUseCase
import com.kazi.breweries.ui.BaseRequestViewModel
import com.kazi.breweries.business.home.model.BreweryDomainModel

/**
 * Home view model class
 * @param homeUseCase Requires HomeUseCase
 */
class HomeViewModel(private val homeUseCase: HomeUseCase) : BaseRequestViewModel() {

    private val mBreweries: MutableLiveData<List<BreweryDomainModel>> = MutableLiveData()

    fun getBreweries(): MutableLiveData<List<BreweryDomainModel>> {
        return mBreweries
    }

    /**
     * Trigger API call to fetch data.
     */
    fun initCall(isConnected: Boolean) {
        if (mBreweries.value == null) {
            val disposable = singleRequest(
                homeUseCase.getBreweriesData(isConnected)
            ).subscribe({
                mBreweries.postValue(it)
            }, {
                handleError(it)
            })
            addDisposable(disposable)
        }
    }
}