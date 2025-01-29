package com.mada.bosta_assessment.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Visibility
import com.mada.bosta_assessment.R
import com.mada.bosta_assessment.databinding.ItemDistrictBinding
import com.mada.domain.entity.Cities

class DistrictAdapter(
    private var districts: List<Cities.Data.District?>,
    private val onDistrictClicked: (Cities.Data.District?) -> Unit
) : RecyclerView.Adapter<DistrictAdapter.DistrictViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DistrictViewHolder {
        val binding = ItemDistrictBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DistrictViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DistrictViewHolder, position: Int) {
        val district = districts[position]
        holder.bind(district)

        holder.itemView.setOnClickListener {
            onDistrictClicked(district)
        }
    }

    override fun getItemCount(): Int = districts.size

    inner class DistrictViewHolder(private val binding: ItemDistrictBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(district: Cities.Data.District?) {
            binding.textViewDistrictName.text = district?.districtName ?: "Unknown"


            if (district?.dropOffAvailability != true) {
                binding.textViewCoverageStatus.text = "Uncovered"
                binding.textViewCoverageStatus.setTextColor(Color.WHITE)
                binding.textViewCoverageStatus.setBackgroundColor(Color.GRAY)
            }
            else{
                binding.textViewCoverageStatus.visibility = View.GONE
            }
        }
    }

    fun updateData(newDistricts: List<Cities.Data.District?>) {
        districts = newDistricts
        notifyDataSetChanged()
    }
}
