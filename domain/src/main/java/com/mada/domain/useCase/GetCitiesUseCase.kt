package com.mada.domain.useCase

import com.mada.domain.entity.Cities
import com.mada.domain.repository.CityRepository

class GetCitiesUseCase(private val repository: CityRepository) {

    suspend operator fun invoke(): Cities {
        return repository.getCitiesAndDistrict()
    }
}