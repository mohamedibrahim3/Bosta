package com.mada.domain.di

import com.mada.domain.repository.CityRepository
import com.mada.domain.useCase.GetCitiesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetCitiesUseCase(repository: CityRepository): GetCitiesUseCase {
        return GetCitiesUseCase(repository)
    }
}