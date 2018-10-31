package com.example.tayler_gabbi.demo_monedero.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.molde_categoria.view.*

class AdapterCategoria : RecyclerView.Adapter<AdapterCategoria.CategoriaViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class CategoriaViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val categoria = itemView.text_view_categoria
        val eliminarcategoria = itemView.image_delete_categoria
        val editarCategoria = itemView.image_edit_categoria

    }

}