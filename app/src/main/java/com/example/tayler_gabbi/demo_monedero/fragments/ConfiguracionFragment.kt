package com.example.tayler_gabbi.demo_monedero.fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tayler_gabbi.demo_monedero.R
import com.example.tayler_gabbi.demo_monedero.listasView.ListaCategoria
import com.example.tayler_gabbi.demo_monedero.listasView.ListaUsuario
import com.example.tayler_gabbi.demo_monedero.view.CategoriaActivity
import org.jetbrains.anko.support.v4.startActivity


class ConfiguracionFragment : Fragment(), View.OnClickListener {
    var miVista: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        miVista = inflater.inflate(R.layout.fragment_configuracion, container, false)

        val btnCategoria = miVista!!.findViewById<View>(R.id.button_categoria)
        btnCategoria.setOnClickListener(this)

        val btnVerCategoria = miVista!!.findViewById<View>(R.id.ver_categoria)
        btnVerCategoria.setOnClickListener(this)

        val btnVerListaUsuario = miVista!!.findViewById<View>(R.id.ver_usuarios)
        btnVerListaUsuario.setOnClickListener(this)


        return miVista
    }
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.button_categoria -> startActivity<CategoriaActivity>()
            R.id.ver_usuarios -> startActivity<ListaUsuario>()
            R.id.ver_categoria -> {
                val intent = Intent(context,ListaCategoria::class.java)
                startActivity(intent)
            }

        }
    }

}
