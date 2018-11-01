package com.example.tayler_gabbi.demo_monedero.listasView

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import com.example.tayler_gabbi.demo_monedero.DemoApplication
import com.example.tayler_gabbi.demo_monedero.R
import com.example.tayler_gabbi.demo_monedero.adapters.AdapterEgreso
import com.example.tayler_gabbi.demo_monedero.adapters.AdapterIngreso
import kotlinx.android.synthetic.main.activity_lista_categoria.*
import kotlinx.android.synthetic.main.activity_lista_ingresos.*
import kotlinx.android.synthetic.main.activity_lista_usuario.*
import kotlin.concurrent.thread

class ListaIngresos : AppCompatActivity() {

    var adapterIngreso : AdapterIngreso? = null
    var handler : Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_ingresos)
        ajustarToolbarIngreso()




        adapterIngreso = AdapterIngreso()

        lista_categoria.layoutManager = LinearLayoutManager(this)
        lista_categoria.adapter = adapterIngreso

        thread(start = true){
            val lista = DemoApplication.database!!.ingresoDao().listarIngresos()
            handler.post {

                adapterIngreso?.agregarLista(lista)
            }

        }

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
