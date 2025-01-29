package com.mada.domain.repository

import com.mada.domain.entity.Cities

interface CityRepository {
    suspend fun getCitiesAndDistrict(): Cities
}