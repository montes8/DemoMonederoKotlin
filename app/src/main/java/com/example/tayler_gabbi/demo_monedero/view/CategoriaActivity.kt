package com.example.tayler_gabbi.demo_monedero.view

import android.content.ContentValues
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tayler_gabbi.demo_monedero.DemoApplication
import com.example.tayler_gabbi.demo_monedero.R
import com.example.tayler_gabbi.demo_monedero.listasView.ListaCategoria
import com.example.tayler_gabbi.demo_monedero.model.Categoria
import kotlinx.android.synthetic.main.activity_categoria.*
import org.jetbrains.anko.startActivity

class CategoriaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categoria)
    }


    fun btnAgregarCategoria(view: View) {

        val categoria = Categoria()
        categoria.Categoria=edit_text_categoria.text.toString()


            val ID = DemoApplication.database!!.categoriaDao().insert(categoria)
            if (ID > 0) {
                Toast.makeText(this, "Categoria agregada correctamente", Toast.LENGTH_LONG).show()
                startActivity<ListaCategoria>()
                finish()
            } else {
                Toast.makeText(this, "Lo siento la categoria no se agrego correctamente ,por favor intentalo de nuevo", Toast.LENGTH_LONG).show()
            }


    }


}
