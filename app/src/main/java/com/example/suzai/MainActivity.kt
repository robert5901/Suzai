package com.example.suzai

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var pagerAdapter: MyPagerAdapter? = null
    var viewPager: ViewPager? = null
    var container: FrameLayout? = null
    var container2: ConstraintLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        container = findViewById(R.id.container)
        container2 = findViewById(R.id.container2)

        //Создаем адаптер и добавляем фрагменты и заголовки для них
        pagerAdapter = MyPagerAdapter(supportFragmentManager)
        pagerAdapter!!.addFragment(NumberOfConsciousnessFragment(this), "Число сознания")
        pagerAdapter!!.addFragment(MissionFragment(), "Миссия")

        //Добавляем viewPager и tabLayout
        viewPager!!.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)

    }
}