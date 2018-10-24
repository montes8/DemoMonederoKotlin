package com.example.tayler_gabbi.demo_monedero.listasView

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.tayler_gabbi.demo_monedero.R
import kotlinx.android.synthetic.main.activity_lista_ingresos.*
import kotlinx.android.synthetic.main.activity_lista_usuario.*

class ListaIngresos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_ingresos)
        ajustarToolbarIngreso()

    }

    fun ajustarToolbarIngreso(){
        setSupportActionBar(toolbar_usuario)
        title = "Lista de Ingresos"
        toolbar_usuario.navigationIcon = getDrawable(R.drawable.ic_atras)
        toolbar_usuario.setOnClickListener{
            onBackPressed()
        }

    }
}
