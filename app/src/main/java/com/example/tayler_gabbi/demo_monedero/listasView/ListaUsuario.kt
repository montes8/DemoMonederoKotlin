package com.example.tayler_gabbi.demo_monedero.listasView

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.tayler_gabbi.demo_monedero.R
import kotlinx.android.synthetic.main.activity_lista_ingresos.*

class ListaUsuario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_usuario)

        ajustarToolbarUsuario()
    }


    fun ajustarToolbarUsuario(){
        setSupportActionBar(toolbar_ingreso)
        title = "Lista de Ingresos"
        toolbar_ingreso.navigationIcon = getDrawable(R.drawable.ic_atras)
        toolbar_ingreso.setOnClickListener{
            onBackPressed()
        }

    }
}
