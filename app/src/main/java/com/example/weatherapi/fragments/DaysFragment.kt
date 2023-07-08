package com.example.weatherapi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapi.MainViewModel
import com.example.weatherapi.R
import com.example.weatherapi.adapters.WeatherAdapter
import com.example.weatherapi.adapters.WeatherModel
import com.example.weatherapi.databinding.FragmentDaysBinding
import com.example.weatherapi.databinding.FragmentHoursBinding


class DaysFragment : Fragment(), WeatherAdapter.Listener {

    private lateinit var binding: FragmentDaysBinding
    private lateinit var weatherAdapter: WeatherAdapter
    private val viewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDaysBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

        viewModel.liveDataList.observe(viewLifecycleOwner) {
            weatherAdapter.submitList(it.subList(1, it.size))
        }

    }


    private fun init() = with(binding){
        weatherAdapter = WeatherAdapter(this@DaysFragment)
        rcView.layoutManager = LinearLayoutManager(activity)
        rcView.adapter = weatherAdapter
    }


    override fun onclick(item: WeatherModel) {
        viewModel.liveDataCurrent.value = item
    }


    companion object {

        @JvmStatic
        fun newInstance() = DaysFragment()
    }
}