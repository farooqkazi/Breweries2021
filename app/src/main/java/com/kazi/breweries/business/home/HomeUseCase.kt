package com.kazi.breweries.business.home

import androidx.annotation.VisibleForTesting
import com.kazi.breweries.business.common.dto.Brewery
import com.kazi.breweries.business.home.model.BreweryDomainModel
import com.kazi.breweries.business.home.repository.HomeLocalRepository
import com.kazi.breweries.business.home.repository.HomeRepository
import com.kazi.breweries.db.BreweryEntity
import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.functions.Function

open class HomeUseCase(
    private val mRemoteRepository: HomeRepository,
    private val mLocalRepository: HomeLocalRepository
) {
    fun getBreweriesData(isConnectedToNetwork: Boolean): Single<List<BreweryDomainModel>> {
        return Single.just(isConnectedToNetwork)
            .flatMap(Function<Boolean, SingleSource<List<Brewery>>> {
                return@Function if (it) mRemoteRepository.getBreweries() else Single.just(
                    Brewery.fromLocal(
                        mLocalRepository.getLocalBreweries()
                    )
                )
            })
            .map {
                if (isConnectedToNetwork) {
                    mLocalRepository.insertAll(fromServer(it))
                }
                return@map BreweryDomainModel.fromList(it)
            }
    }

    @VisibleForTesting
    fun fromServer(breweries: List<Brewery>): List<BreweryEntity> {
        val list = mutableListOf<BreweryEntity>()
        breweries.forEach {
            list.add(
                BreweryEntity(
                    it.mId,
                    it.mName,
                    it.mType,
                    it.mStreet,
                    it.mCity,
                    it.mState,
                    it.mPostalCode,
                    it.mCountry,
                    it.mLatitude,
                    it.mLongitude,
                    it.mPhone,
                    it.mUrl,
                    it.mUpdatedAt
                )
            )
        }
        return list
    }
}