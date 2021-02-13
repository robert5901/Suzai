package com.example.suzai

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import kotlinx.android.synthetic.main.fragment_consciousness_info.*

class ConsciousnessInfoFragment(mainActivity: MainActivity) : Fragment() {

    private val context = mainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // нажатие на физическую кнопку
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (fragmentManager != null){
                    context.container!!.visibility = View.GONE
                    context.container2!!.visibility = View.VISIBLE
                    if (fragmentManager!!.findFragmentByTag("Info") != null) {
                        fragmentManager!!.beginTransaction()
                            .hide(fragmentManager!!.findFragmentByTag("Info")!!).commit()
                        fragmentManager!!.beginTransaction()
                            .remove(fragmentManager!!.findFragmentByTag("Info")!!).commit()
                    }
                }
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_consciousness_info, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Кнопка "Назад" в AppBar
        back_btn.setOnClickListener {
            if (fragmentManager != null){
                context.container!!.visibility = View.GONE
                context.container2!!.visibility = View.VISIBLE
                if (fragmentManager!!.findFragmentByTag("Info") != null) {
                    fragmentManager!!.beginTransaction()
                        .hide(fragmentManager!!.findFragmentByTag("Info")!!).commit()
                    fragmentManager!!.beginTransaction()
                        .remove(fragmentManager!!.findFragmentByTag("Info")!!).commit()
                }
            }
        }
    }


}