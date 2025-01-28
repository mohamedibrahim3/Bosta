package com.mada.bosta_assessment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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
    private var cities: List<City> = emptyList()
    private var selectedCity: City? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        setupUI()
        observeViewModel()
    }

    private fun setupUI(){

        //Setup RecyclerView
        districtAdapter = DistrictAdapter(emptyList())
        binding.recyclerViewDistricts.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewDistricts.adapter = districtAdapter

        // Setup SearchBar interaction
        binding.searchView.setOnClickListener {
            // عند النقر على SearchBar، قم بإظهار Spinner
            binding.spinnerCities.visibility = View.VISIBLE
        }

        // التعامل مع تغيير النص في SearchBar
        val searchText = binding.searchView
            .findViewById<EditText>(com.google.android.material.R.id.search_bar)
        searchText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // تصفية القائمة بناءً على النص المدخل
                val query = s?.toString() ?: ""
                val filteredCities = cities.filter { it.name.contains(query, ignoreCase = true) }
                updateCitySpinner(filteredCities)
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        // Setup Spinner
        binding.spinnerCities.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedCity = cities[position]
                viewModel.filterDistricts(selectedCity!!, "")
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }
    private fun observeViewModel() {
        viewModel.cities.observe(this) { cityList ->
            cities = cityList
            updateCitySpinner(cities)
        }

        viewModel.filteredDistricts.observe(this) { filteredList ->
            districtAdapter.updateData(filteredList)
        }
    }

    private fun updateCitySpinner(cityList: List<City>) {
        val cityNames = cityList.map { it.name }
        spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cityNames)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerCities.adapter = spinnerAdapter
    }
}