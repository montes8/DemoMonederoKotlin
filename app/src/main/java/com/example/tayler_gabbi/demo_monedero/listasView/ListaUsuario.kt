package com.example.tayler_gabbi.demo_monedero.listasView

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import com.example.tayler_gabbi.demo_monedero.DemoApplication
import com.example.tayler_gabbi.demo_monedero.R
import com.example.tayler_gabbi.demo_monedero.adapters.AdapterCategoria
import com.example.tayler_gabbi.demo_monedero.adapters.AdapterUsuario
import kotlinx.android.synthetic.main.activity_lista_categoria.*
import kotlinx.android.synthetic.main.activity_lista_ingresos.*
import kotlinx.android.synthetic.main.activity_lista_usuario.*
import kotlin.concurrent.thread

class ListaUsuario : AppCompatActivity() {

    var usuarioAdapter : AdapterUsuario? = null
    var handler : Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_usuario)

        ajustarToolbarUsuario()

        usuarioAdapter = AdapterUsuario()

        lista_usuario.layoutManager = LinearLayoutManager(this)
        lista_usuario.adapter = usuarioAdapter

        thread(start = true){
            val lista = DemoApplication.database!!.usuarioDao().listarUsuario()
            handler.post {

                usuarioAdapter?.agregarLista(lista)
            }

        }
    }


    fun ajustarToolbarUsuario(){
        setSupportActionBar(toolbar_usuario)
        title = "Lista de Ingresos"
        toolbar_usuario.navigationIcon = getDrawable(R.drawable.ic_atras)
        toolbar_usuario.setNavigationOnClickListener{
            onBackPressed()
        }

    }
}
