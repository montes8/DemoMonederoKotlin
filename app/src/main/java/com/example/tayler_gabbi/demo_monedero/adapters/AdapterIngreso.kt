package com.example.tayler_gabbi.demo_monedero.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tayler_gabbi.demo_monedero.R
import com.example.tayler_gabbi.demo_monedero.model.Egresos
import com.example.tayler_gabbi.demo_monedero.model.Ingresos
import kotlinx.android.synthetic.main.molde_lista_gasto.view.*

class AdapterIngreso (  val onClickEliminarIngreso : ((Ingresos) -> Unit)? = null ): RecyclerView.Adapter<AdapterIngreso.IngresoViewHolder>(){

    private var ingresos : List<Ingresos>? = null

    fun agregarLista (gastos : List<Ingresos>){
        this.ingresos = ingresos

        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngresoViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.model_lista,parent,false)
        return IngresoViewHolder(view)
    }

    override fun getItemCount(): Int {
        val checkedUser = checkNotNull(ingresos){return 0}

        return checkedUser.size
    }

    override fun onBindViewHolder(holder: IngresoViewHolder, position: Int) {
        val ingreso = ingresos!![position]

        holder.descripcionIngreso.text = ingreso.descripcion
        holder.montoIngreso.text = ingreso.monto.toString()
        holder.fechaIngreso.text = ingreso.dia.toString() + " // " + ingreso.mes + " // " + ingreso.anio


        holder.eliminarIngreso.setOnClickListener {

            onClickEliminarIngreso?.invoke(ingreso)
        }


    }


    class IngresoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){


        val descripcionIngreso = itemView.text_egreso_descricion
        val montoIngreso = itemView.text_monto_engreso
        val fechaIngreso = itemView.text_fecha_gasto
        val eliminarIngreso = itemView.image_delete_egreso

    }
}