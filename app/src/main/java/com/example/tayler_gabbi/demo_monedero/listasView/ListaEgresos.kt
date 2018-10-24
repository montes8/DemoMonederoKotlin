package com.example.tayler_gabbi.demo_monedero.listasView

import android.content.ContentValues
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.example.tayler_gabbi.demo_monedero.R
import kotlinx.android.synthetic.main.activity_lista_egresos.*
import kotlinx.android.synthetic.main.fragment_egresos.*
import org.jetbrains.anko.support.v4.longToast
import org.jetbrains.anko.support.v4.startActivity
import java.util.*

class ListaEgresos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_egresos)

        ajustarToolbarGastos()


    }

    fun ajustarToolbarGastos(){
        setSupportActionBar(toolbar_gastos)
        title = "Lista de Gastos"
        toolbar_gastos.navigationIcon = getDrawable(R.drawable.ic_atras)
        toolbar_gastos.setOnClickListener{
            onBackPressed()
        }

    }
}
