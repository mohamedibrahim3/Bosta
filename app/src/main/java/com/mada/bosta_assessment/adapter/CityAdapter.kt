package com.mada.bosta_assessment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mada.bosta_assessment.R
import com.mada.bosta_assessment.databinding.ItemCityBinding
import com.mada.domain.entity.City

class CityAdapter(private val cities: List<City>) : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    private var filteredCities: List<City> = cities

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCityBinding.inflate(inflater, parent, false)
        return CityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(filteredCities[position])
    }

    override fun getItemCount(): Int = filteredCities.size

    fun filter(query: String) {
        filteredCities = if (query.isEmpty()) {
            cities
        } else {
            cities.filter { it.name.contains(query, ignoreCase = true) }
        }
        notifyDataSetChanged()
    }

    class CityViewHolder(private val binding: ItemCityBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(city: City) {
            binding.cityName.text = city.name
        }
    }
}