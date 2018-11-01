package com.example.tayler_gabbi.demo_monedero.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tayler_gabbi.demo_monedero.R
import com.example.tayler_gabbi.demo_monedero.model.Egresos
import com.example.tayler_gabbi.demo_monedero.model.Usuario
import kotlinx.android.synthetic.main.molde_categoria.view.*
import kotlinx.android.synthetic.main.molde_list_user.view.*
import kotlinx.android.synthetic.main.molde_lista_gasto.view.*

class AdapterEgreso (  val onClickEliminarGasto : ((Egresos) -> Unit)? = null ): RecyclerView.Adapter<AdapterEgreso.EgresoViewHolder>(){

    private var gastos : List<Egresos>? = null

    fun agregarLista (gastos : List<Egresos>){
        this.gastos = gastos

        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EgresoViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.molde_lista_gasto,parent,false)
        return EgresoViewHolder(view)
    }

    override fun getItemCount(): Int {
        val checkedUser = checkNotNull(gastos){return 0}

        return checkedUser.size
    }

    override fun onBindViewHolder(holder: EgresoViewHolder, position: Int) {
        val gasto = gastos!![position]

        holder.categoriaGasto.text = gasto.categoria
        holder.descripciongasto.text = gasto.descripcion
        holder.monto.text = gasto.monto.toString()
        holder.fechaGasto.text = gasto.dia.toString() + " // " + gasto.mes + " // " + gasto.anio


        holder.eliminarGasto.setOnClickListener {

            onClickEliminarGasto?.invoke(gasto)
        }


    }


    class EgresoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val categoriaGasto = itemView.text_categoria_egreso
        val descripciongasto = itemView.text_egreso_descricion
        val monto = itemView.text_monto_engreso
        val fechaGasto = itemView.text_fecha_gasto
        val eliminarGasto = itemView.image_delete_egreso

    }
}