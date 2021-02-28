package com.example.suzai.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.suzai.R
import kotlinx.android.synthetic.main.main_fragment.*
import java.text.DateFormatSymbols
import java.util.*

class MainFragment() : Fragment(){


    val calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.main_fragment,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arrayMonths : Array<String>
        val dfs = DateFormatSymbols(Locale("RU"))

        arrayMonths = dfs.months // запись в месяцев из DateFormatSymbols в массив

        // выпадающий список с месяцами
        val arrayAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_dropdown_item_1line,
                arrayMonths
        )
        autoCompleteTextView.setAdapter(arrayAdapter)
        autoCompleteTextView.threshold = 12

        btn_mission.setOnClickListener {
            //Условие

            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                    .navigate(R.id.action_mainFragment_to_missionInfoFragment)

        }

        btn_num_of_consciousness.setOnClickListener {
            //Условие

            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                    .navigate(R.id.action_mainFragment_to_consciousnessInfoFragment)

        }
    }
}