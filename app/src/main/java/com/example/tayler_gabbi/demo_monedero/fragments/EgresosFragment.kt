package com.example.tayler_gabbi.demo_monedero.fragments


import android.content.ContentValues
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.TextView
import com.example.tayler_gabbi.demo_monedero.R
import com.example.tayler_gabbi.demo_monedero.listasView.ListaEgresos
import com.example.tayler_gabbi.demo_monedero.model.Egresos
import kotlinx.android.synthetic.main.fragment_egresos.*
import java.util.*


class EgresosFragment : Fragment() {

    var category: String? = null
    var fecha: TextView? = null
    var messs: TextView? = null
    var anios: TextView? = null
    var miVista: View? = null
    var id: Int? = 0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_egresos, container, false)
        }

}
