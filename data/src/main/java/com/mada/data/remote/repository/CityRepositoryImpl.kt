package com.mada.data.remote.repository

import com.mada.data.remote.service.ApiService
import com.mada.domain.entity.Cities
import com.mada.domain.repository.CityRepository
import javax.inject.Inject

class CityRepositoryImpl@Inject constructor(private val apiService: ApiService): CityRepository {
    override suspend fun getCitiesAndDistrict(): Cities {
        return apiService.getCitiesAndDistricts()
    }

}