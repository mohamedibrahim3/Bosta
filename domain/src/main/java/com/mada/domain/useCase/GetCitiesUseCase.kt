package com.mada.domain.useCase

import com.mada.domain.entity.City
import com.mada.domain.repository.CityRepository

class GetCitiesUseCase(private val repository: CityRepository) {

    suspend operator fun invoke(): List<City>{
        return repository.getCitiesAndDistrict()
    }
}