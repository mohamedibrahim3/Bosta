package com.mada.bosta_assessment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.animation.ObjectAnimator
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.mada.bosta_assessment.R
import com.mada.bosta_assessment.databinding.ItemCityBinding
import com.mada.domain.entity.Cities

class ExpandableCityAdapter(
    private var cities: List<Cities.Data>,
    private val onDistrictClicked: (Cities.Data.District?) -> Unit
) : RecyclerView.Adapter<ExpandableCityAdapter.CityViewHolder>() {

    private var filteredCities: List<Cities.Data> = cities
    private val expandedStates = mutableMapOf<Int, Boolean>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCityBinding.inflate(inflater, parent, false)
        return CityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(filteredCities[position], expandedStates[position] == true)
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

    // تحديث البيانات
    fun updateData(newCities: List<Cities.Data>) {
        cities = newCities
        filteredCities = newCities
        notifyDataSetChanged()
    }

    inner class CityViewHolder(private val binding: ItemCityBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(city: Cities.Data, isExpanded: Boolean) {
            binding.cityName.text = city.cityName ?: "Unknown City"

            if (isExpanded) {
                binding.arrowIcon.setImageResource(R.drawable.ic_arrow_up)
                binding.DistrictRV.visibility = View.VISIBLE

                val adapter = city.districts?.let {
                    DistrictAdapter(it) { district ->
                        onDistrictClicked(district)
                    }
                }
                binding.DistrictRV.adapter = adapter
                binding.DistrictRV.layoutManager = LinearLayoutManager(binding.root.context)

                val slideIn = ObjectAnimator.ofFloat(binding.DistrictRV, "translationY", binding.DistrictRV.height.toFloat(), 0f)
                slideIn.duration = 300
                slideIn.start()
            } else {
                binding.arrowIcon.setImageResource(R.drawable.ic_arrow_down)

                val slideOut = ObjectAnimator.ofFloat(binding.DistrictRV, "translationY", 0f, binding.DistrictRV.height.toFloat())
                slideOut.duration = 300
                slideOut.start()

                binding.DistrictRV.visibility = View.GONE
            }

            binding.root.setOnClickListener {
                val isCurrentlyExpanded = expandedStates[adapterPosition] ?: false
                expandedStates[adapterPosition] = !isCurrentlyExpanded

                if (isCurrentlyExpanded) {
                    val slideOut = ObjectAnimator.ofFloat(binding.DistrictRV, "translationY", 0f, binding.DistrictRV.height.toFloat())
                    slideOut.duration = 300
                    slideOut.start()
                } else {
                    val slideIn = ObjectAnimator.ofFloat(binding.DistrictRV, "translationY", binding.DistrictRV.height.toFloat(), 0f)
                    slideIn.duration = 300
                    slideIn.start()
                }
                notifyItemChanged(adapterPosition)
            }
        }
    }
}
