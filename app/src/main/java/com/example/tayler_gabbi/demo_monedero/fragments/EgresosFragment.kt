package com.example.tayler_gabbi.demo_monedero.fragments


import android.content.ContentValues
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.example.tayler_gabbi.demo_monedero.DemoApplication
import com.example.tayler_gabbi.demo_monedero.R
import com.example.tayler_gabbi.demo_monedero.listasView.ListaEgresos
import com.example.tayler_gabbi.demo_monedero.model.Categoria
import com.example.tayler_gabbi.demo_monedero.model.Egresos
import com.example.tayler_gabbi.demo_monedero.model.Usuario
import com.example.tayler_gabbi.demo_monedero.view.NavegacionActivity
import kotlinx.android.synthetic.main.activity_registrar.*
import kotlinx.android.synthetic.main.fragment_egresos.*
import org.jetbrains.anko.clearTask
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.newTask
import org.jetbrains.anko.support.v4.intentFor
import org.jetbrains.anko.support.v4.longToast
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.thread


class EgresosFragment : Fragment(), View.OnClickListener {

    var category: String? = null
    var fecha: TextView? = null
    var messs: TextView? = null
    var anios: TextView? = null
    var miVista: View? = null
    var handler : Handler = Handler()
    lateinit var spiner : Spinner
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        miVista = inflater.inflate(R.layout.fragment_egresos, container, false)


        fecha = miVista!!.findViewById<View>(R.id.fecha_gasto) as TextView
        messs = miVista!!.findViewById<View>(R.id.mes_gasto) as TextView
        anios = miVista!!.findViewById<View>(R.id.anio_gasto) as TextView
        val desEgreso = miVista!!.findViewById<View>(R.id.descripcion_gasto)
        val montoEgreso = miVista!!.findViewById<View>(R.id.monto_gasto)

        spiner = miVista!!.findViewById<View>(R.id.combo_categoria) as Spinner

        listaCategoria()

        val btnEngreso = miVista!!.findViewById<View>(R.id.agregar_egreso)
        mostrarFecha()
        btnEngreso.setOnClickListener(this)
        val btnVerListaEgreso = miVista!!.findViewById<View>(R.id.ver_lista_egresos)
        btnVerListaEgreso.setOnClickListener(this)

        return miVista
        }
    override fun onClick(v: View?) {
        when (v!!.id) {

            R.id.agregar_egreso -> {

                Thread {
                    if (descripcion_gasto.text.toString().isEmpty()) {

                        handler.post { toast("ingrese nombre") }

                    } else if (monto_gasto.text.toString().isEmpty()) {
                        handler.post { toast("Ingrese nombre de usuario") }

                    } else if (fecha_gasto.text.toString().isEmpty()) {
                        handler.post { toast("Ingrese contraseña") }

                    } else {


                        val egresos = Egresos()
                        egresos.categoria = category.toString()
                        egresos.descripcion = descripcion_gasto.text.toString()
                        egresos.monto = monto_gasto.text.toString().toDouble()
                        egresos.dia = fecha_gasto.toString()
                        egresos.mes = mes_gasto.toString()
                        egresos.anio = anio_gasto.toString()

                        val nuevoIdEgreso = DemoApplication.database!!.egresoDao().insert(egresos)
                        if (nuevoIdEgreso > 0) {
                            Log.i("idregistrado", "$nuevoIdEgreso")
                            handler.post {
                                toast("gasto Registrado")
                                edit_text_name.setText("")
                                edit_text_usuario.setText("")
                                edit_text_password.setText("")
                            }
                        } else {
                            handler.post { toast("errorrrr") }
                        }
                    }
                }.start()
            }
            R.id.ver_lista_egresos -> {
            startActivity<ListaEgresos>()
          }
        }
    }

    fun mostrarFecha() {
        val c = Calendar.getInstance()
        val dia = c.get(Calendar.DAY_OF_MONTH)
        val mes = c.get(Calendar.MONTH)
        val mess = mes + 1
        val anio = c.get(Calendar.YEAR)
        //val fechas="$dia / $mess / $anio"
        fecha!!.text = dia.toString()
        messs!!.text = mess.toString()
        anios!!.text = anio.toString()
    }

    fun listaCategoria (){

        thread {

            val listCategoria = ArrayList<String>()
            val lista: ArrayList<Categoria> = DemoApplication.database!!.categoriaDao().listarCategorias() as ArrayList<Categoria>
            lista.forEach {
                listCategoria.add(it.Categoria)
            }


            val adapter = ArrayAdapter<String>(this.context, android.R.layout.simple_spinner_item, listCategoria)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spiner!!.setAdapter(adapter)
            spiner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    category = parent!!.getItemAtPosition(position).toString()
                }
            }
        }

    }
}
