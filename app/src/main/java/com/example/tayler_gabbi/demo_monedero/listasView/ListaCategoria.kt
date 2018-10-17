package com.example.tayler_gabbi.demo_monedero.listasView

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.tayler_gabbi.demo_monedero.R
import kotlinx.android.synthetic.main.activity_lista_categoria.*

class ListaCategoria : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_categoria)


    }

    fun ajusteToolbar(){

        setSupportActionBar(toolbar_lista_categoria)
        toolbar_lista_categoria.navigationIcon = getDrawable(R.drawable.ic_atras)
        toolbar_lista_categoria.setOnClickListener{
            onBackPressed()
        }
    }
}
