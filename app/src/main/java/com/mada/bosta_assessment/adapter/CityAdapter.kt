package com.mada.bosta_assessment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.mada.bosta_assessment.R
import com.mada.bosta_assessment.databinding.ItemCityBinding
import com.mada.domain.entity.Cities

class CityAdapter(private var cities: List<Cities.Data>, private val onDistrictClicked: (Cities.Data.District?) -> Unit) : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    private var filteredCities: List<Cities.Data> = cities

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCityBinding.inflate(inflater, parent, false)
        return CityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(filteredCities[position], false)
    }

    override fun getItemCount(): Int = filteredCities.size

    fun filter(query: String) {
        filteredCities = if (query.isEmpty()) {
            cities
        } else {
            cities.filter {
                it.cityName?.contains(query, ignoreCase = true) == true ||
                        it.cityOtherName?.contains(query, ignoreCase = true) == true
            }
        }
        notifyDataSetChanged()
    }

    fun updateData(newCities: List<Cities.Data>) {
        cities = newCities
        filteredCities = newCities
        notifyDataSetChanged()
    }

    class CityViewHolder(private val binding: ItemCityBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(city: Cities.Data, isExpanded: Boolean) {
            binding.cityName.text = city.cityName ?: "Unknown City"
            if (isExpanded) {
                binding.arrowIcon.setImageResource(R.drawable.ic_arrow_up)
                binding.DistrictRV.visibility = View.VISIBLE
                val adapter = city.districts?.let {
                    DistrictAdapter(it) { district ->
                    }
                }
                binding.DistrictRV.adapter = adapter
                binding.DistrictRV.layoutManager = LinearLayoutManager(binding.root.context)
            } else {
                binding.arrowIcon.setImageResource(R.drawable.ic_arrow_down)
                binding.DistrictRV.visibility = View.GONE
            }
        }
    }
}
