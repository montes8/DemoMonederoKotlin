package com.example.tayler_gabbi.demo_monedero.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.tayler_gabbi.demo_monedero.fragments.ConfiguracionFragment
import com.example.tayler_gabbi.demo_monedero.fragments.EgresosFragment
import com.example.tayler_gabbi.demo_monedero.fragments.IngresosFragment


@Suppress("UNREACHABLE_CODE")
class PageAdapter (fm:FragmentManager?, val numTabs:Int):FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        return return when(position){
            0 -> EgresosFragment()
            1 -> IngresosFragment()
            2 -> ConfiguracionFragment()
            else -> null
        }

    }
    override fun getCount(): Int {

        return numTabs
    }
}