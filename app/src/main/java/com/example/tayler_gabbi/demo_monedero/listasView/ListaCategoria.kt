package com.example.tayler_gabbi.demo_monedero.listasView

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import com.example.tayler_gabbi.demo_monedero.DemoApplication
import com.example.tayler_gabbi.demo_monedero.R
import com.example.tayler_gabbi.demo_monedero.adapters.AdapterCategoria
import kotlinx.android.synthetic.main.activity_lista_categoria.*
import kotlin.concurrent.thread

class ListaCategoria : AppCompatActivity() {

    var categoriaAdapter : AdapterCategoria? = null

    var hamdler : Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_categoria)

        ajusteToolbar()

        categoriaAdapter = AdapterCategoria()

        lista_categoria.layoutManager = LinearLayoutManager(this)
        lista_categoria.adapter = categoriaAdapter

       thread(start = true){
           val lista = DemoApplication.database!!.categoriaDao().listarCategorias()
           hamdler.post {

               categoriaAdapter?.agregarLista(lista)
           }

       }

    }

    fun ajusteToolbar(){

        setSupportActionBar(toolbar_lista_categoria)
        toolbar_lista_categoria.title = "LISTA DE CATEGORIAS"
        toolbar_lista_categoria.navigationIcon = getDrawable(R.drawable.ic_atras)
        toolbar_lista_categoria.setOnClickListener{
            onBackPressed()
        }
    }
}
