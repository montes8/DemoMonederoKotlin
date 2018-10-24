package com.example.tayler_gabbi.demo_monedero.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import com.example.tayler_gabbi.demo_monedero.R
import com.example.tayler_gabbi.demo_monedero.adapters.PageAdapter
import kotlinx.android.synthetic.main.activity_navegacion.*

class NavegacionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navegacion)
        setSupportActionBar(toolbar_navigation)
        title = "MONEDERO"

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val vPager: ViewPager = findViewById(R.id.viewPager)
        val pAdapter = PageAdapter(supportFragmentManager, tabLayout.tabCount)
        vPager.adapter = pAdapter

        vPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab) {
                //Toast.makeText(this@NavegacionActivity, "tabeselected: " + tab.text, Toast.LENGTH_LONG).show()
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {
                //Toast.makeText(this@NavegacionActivity, "tabUnselected: " + tab.text, Toast.LENGTH_LONG).show()
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                val posicion = tab.position
                vPager.currentItem = posicion
                // Toast.makeText(this@NavegacionActivity, "tabselected: " + tab.text, Toast.LENGTH_LONG).show()
            }
        })
    }
}
