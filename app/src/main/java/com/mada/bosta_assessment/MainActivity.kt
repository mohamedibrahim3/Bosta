package com.mada.bosta_assessment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mada.bosta_assessment.adapter.CityAdapter
import com.mada.bosta_assessment.adapter.DistrictAdapter
import com.mada.bosta_assessment.databinding.ActivityMainBinding
import com.mada.bosta_assessment.viewModel.CityViewModel
import com.mada.domain.entity.City
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: CityViewModel by viewModels()
    private lateinit var spinnerAdapter: ArrayAdapter<String>
    private lateinit var districtAdapter: DistrictAdapter
    private lateinit var adapter: CityAdapter
    private var cities: List<City> = emptyList()
    private var selectedCity: City? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        adapter = CityAdapter(emptyList())

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

        viewModel.cities.observe(this, Observer { cities ->
            adapter = CityAdapter(cities)
            binding.recyclerViewCity.adapter = adapter
        })

        viewModel.fetchCities()
    }
}
