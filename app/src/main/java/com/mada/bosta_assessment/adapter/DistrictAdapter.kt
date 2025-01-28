package com.mada.bosta_assessment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mada.bosta_assessment.databinding.ItemDistrictBinding
import com.mada.domain.entity.District

class DistrictAdapter(private var districts: List<District>)
    : RecyclerView.Adapter<DistrictAdapter.DistrictViewHolder>(){

        class DistrictViewHolder(val binding: ItemDistrictBinding)
            : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DistrictViewHolder {
        val binding = ItemDistrictBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DistrictViewHolder(binding)
    }

    override fun getItemCount(): Int = districts.size

    override fun onBindViewHolder(holder: DistrictViewHolder, position: Int) {
        val districts = districts[position]
        holder.binding.textViewDistrictName.text = districts.name
        holder.binding.textViewCoverageStatus.text = if (districts.isCovered) "Covered" else "Uncovered"
    }

    fun updateData(newDistricts: List<District>) {
        districts = newDistricts
        notifyDataSetChanged()
    }

}