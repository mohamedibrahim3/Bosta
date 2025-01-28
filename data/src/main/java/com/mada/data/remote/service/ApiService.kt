package com.mada.data.remote.service

import com.mada.domain.entity.City
import retrofit2.http.GET

interface ApiService {
    @GET("cities/getAllDistricts?countryId=60e4482c7cb7d4bc4849c4d5")
    suspend fun getCitiesAndDistricts(): List<City>

}