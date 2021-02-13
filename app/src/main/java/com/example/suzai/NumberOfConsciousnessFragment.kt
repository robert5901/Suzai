package com.example.suzai

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_number_of_consciousness_fragment.*
import java.text.DateFormatSymbols
import java.util.*

class NumberOfConsciousnessFragment(mainActivity: MainActivity) : Fragment(){

    val context = mainActivity
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
            R.layout.fragment_number_of_consciousness_fragment,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arrayMonths : Array<String>
        val dfs = DateFormatSymbols(Locale("RU"))

        arrayMonths = dfs.months

        val arrayAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_dropdown_item_1line,
                arrayMonths
        )
        autoCompleteTextView.setAdapter(arrayAdapter)

        autoCompleteTextView.threshold = 12

        button.setOnClickListener {
            //Условие

            if (fragmentManager != null){
                context.container2!!.visibility = View.GONE
                context.container!!.visibility = View.VISIBLE
                if (fragmentManager!!.findFragmentByTag("Info") != null) {
                    fragmentManager!!.beginTransaction()
                        .show(fragmentManager!!.findFragmentByTag("Info")!!).commit()
                }
                else {
                    fragmentManager!!.beginTransaction()
                        .add(context.container!!.id, ConsciousnessInfoFragment(context), "Info")
                        .commit()
                }
            }
        }

    }
}