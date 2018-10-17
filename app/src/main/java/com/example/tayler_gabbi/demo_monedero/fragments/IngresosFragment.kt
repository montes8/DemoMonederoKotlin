package com.example.tayler_gabbi.demo_monedero.fragments


import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.tayler_gabbi.demo_monedero.DemoApplication
import com.example.tayler_gabbi.demo_monedero.R
import com.example.tayler_gabbi.demo_monedero.model.Ingresos
import kotlinx.android.synthetic.main.activity_registrar.*
import kotlinx.android.synthetic.main.fragment_ingresos.*
import org.jetbrains.anko.support.v4.toast
import java.util.*


class IngresosFragment : Fragment(),View.OnClickListener {

    var fechaIngreso: TextView? = null
    var mesi: TextView? = null
    var aniosi: TextView? = null
    var tota: TextView? = null
    var miVista:View?=null
    var handler : Handler = Handler()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        miVista = inflater.inflate(R.layout.fragment_ingresos, container, false)

        fechaIngreso = miVista!!.findViewById<View>(R.id.edit_fecha_ingreso) as TextView?
        mesi = miVista!!.findViewById<View>(R.id.edit_mes_ingreso) as TextView?
        aniosi = miVista!!.findViewById<View>(R.id.edit_anio_ingreso) as TextView?
        val textIngreso=miVista!!.findViewById<View>(R.id.descripcion_ingreso)
        val textMonto=miVista!!.findViewById<View>(R.id.monto_ingreso)
        val btnIngreso=miVista!!.findViewById<View>(R.id.agregar_ingreso)
        mostrarFechaIngreso()
        btnIngreso.setOnClickListener(this)
        val btnVerLista=miVista!!.findViewById<View>(R.id.ver_lista_ingresos)
        btnVerLista.setOnClickListener(this)

        return miVista

    }

    fun mostrarFechaIngreso(){

        val c= Calendar.getInstance()
        val dia=c.get(Calendar.DAY_OF_MONTH)
        val mes=c.get(Calendar.MONTH)
        val mess=mes+1
        val anio=c.get(Calendar.YEAR)
        //val fechas="$dia / $mess / $anio"
        fechaIngreso!!.text= dia.toString()
        mesi!!.text=mess.toString()
        aniosi!!.text=anio.toString()
    }




    override fun onClick(v: View?) {
        when (v!!.id){

            R.id.agregar_ingreso  ->{

                Thread {
                    val ingreso = Ingresos()
                    ingreso.descripcion = descripcion_ingreso.text.toString()
                    ingreso.monto = monto_ingreso.text.toString().toInt()
                    ingreso.dia=edit_fecha_ingreso.text.toString()
                    ingreso.mes = edit_mes_ingreso.text.toString()
                    ingreso.anio = edit_anio_ingreso.text.toString()
                    if (descripcion_ingreso.text.toString().isEmpty()) {

                        handler.post { toast("ingrese descripcion") }

                    } else if (monto_ingreso.text.toString().isEmpty()) {
                        handler.post { toast("Ingrese monto") }

                    } else if (edit_fecha_ingreso.text.toString().isEmpty()) {
                        handler.post { toast("Ingrese fecha") }

                    } else {

                        val nuevoIngreso = DemoApplication.database!!.ingresoDao().insert(ingreso)
                        if (nuevoIngreso > 0) {
                            Log.i("idregistrado", "$nuevoIngreso")
                            handler.post {
                                toast("Ingreso Registrado")
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

            R.id.ver_lista_ingresos -> {
            }
        }
    }

}
