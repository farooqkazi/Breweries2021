package com.kazi.breweries

import android.app.Application
import com.kazi.breweries.di.databaseModule
import com.kazi.breweries.di.repositoryModule
import com.kazi.breweries.di.retrofitModule
import com.kazi.breweries.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Main Application class, which is
 * responsible to init the Koin DI.
 */
class BreweriesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@BreweriesApplication)
            /*Modules declaration*/
            modules(
                listOf(
                    retrofitModule,
                    repositoryModule,
                    databaseModule,
                    viewModelModule
                )
            )
        }
    }
}