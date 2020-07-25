package com.example.myapplication.di.modules

import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.AppConstant
import com.example.myapplication.repository.EarthQuakesRepository
import com.example.myapplication.viewmodel.ViewmodelFactory
import dagger.Module
import dagger.Provides
import java.net.URL
import javax.inject.Singleton

@Module
class NetworkingModule {

    @Provides
    @Singleton
    fun provideViewModelFactory(repository: EarthQuakesRepository): ViewModelProvider.Factory {
        return ViewmodelFactory(repository)
    }

    @Provides
    fun provideEarthQuakesRepository(url: URL): EarthQuakesRepository {
        return EarthQuakesRepository(url)
    }

    @Provides
    @Singleton
    fun provideURL() :URL {
        return URL(AppConstant.EARTH_QUAKE_URL)
    }

}