package com.mada.bosta_assessment.viewModel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Query
import com.mada.domain.entity.City
import com.mada.domain.entity.District
import com.mada.domain.useCase.GetCitiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CityViewModel @Inject constructor(private val getCitiesUseCase: GetCitiesUseCase)
    :ViewModel(){

        private val _cities = MutableLiveData<List<City>>()
        val cities : LiveData<List<City>>
            get() = _cities

        private val _filterDistricts = MutableLiveData<List<District>>()
        val filteredDistricts: LiveData<List<District>>
            get() = _filterDistricts

    fun fetchCities(){
        viewModelScope.launch {
            try {
                _cities.value = getCitiesUseCase()
            }catch (e:Exception){
                Log.e(TAG, "ERROR FETCHING URLS $e")
            }
        }
    }

    fun filterDistricts(city: City, query: String){
        _filterDistricts.value = city.districts.filter {
            it.name.contains(query, ignoreCase = true)
        }

    }

}