package com.mada.data.di

import com.mada.data.remote.repository.CityRepositoryImpl
import com.mada.data.remote.service.ApiService
import com.mada.domain.repository.CityRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideCityRepository(apiService: ApiService): CityRepository {
        return CityRepositoryImpl(apiService)
    }
}