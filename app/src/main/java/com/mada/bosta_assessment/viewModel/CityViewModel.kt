package com.mada.bosta_assessment.viewModel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mada.domain.entity.Cities
import com.mada.domain.useCase.GetCitiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CityViewModel @Inject constructor(private val getCitiesUseCase: GetCitiesUseCase)
    : ViewModel() {

    private val _cities = MutableLiveData<List<Cities.Data>>()
    val cities: LiveData<List<Cities.Data>>
        get() = _cities

    fun fetchCities() {
        viewModelScope.launch {
            try {
                val response = getCitiesUseCase()
                _cities.value = response.data?.filterNotNull() ?: emptyList()
            } catch (e: Exception) {
                Log.e("CityViewModel", "Error fetching cities", e)
            }
        }
    }
}

