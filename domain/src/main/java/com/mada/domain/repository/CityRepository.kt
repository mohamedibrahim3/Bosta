package com.mada.domain.repository

import com.mada.domain.entity.City

interface CityRepository {
    suspend fun getCitiesAndDistrict(): List<City>
}