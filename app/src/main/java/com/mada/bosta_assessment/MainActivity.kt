package com.mada.bosta_assessment

import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mada.bosta_assessment.adapter.ExpandableCityAdapter
import com.mada.bosta_assessment.databinding.ActivityMainBinding
import com.mada.bosta_assessment.viewModel.CityViewModel
import com.mada.domain.entity.Cities
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: CityViewModel by viewModels()
    private lateinit var adapter: ExpandableCityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ExpandableCityAdapter(emptyList()) { district ->
            Toast.makeText(this, "Clicked on: ${district?.districtName}", Toast.LENGTH_SHORT).show()

        }

        binding.recyclerViewCity.adapter = adapter
        binding.recyclerViewCity.layoutManager = LinearLayoutManager(this)

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter(newText ?: "")
                return true
            }
        })

        viewModel.cities.observe(this) { citiesList ->
            adapter.updateData(citiesList)
        }

        viewModel.fetchCities()
    }
}
