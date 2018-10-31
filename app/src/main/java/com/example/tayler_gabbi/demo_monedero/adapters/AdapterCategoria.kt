package com.example.tayler_gabbi.demo_monedero.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tayler_gabbi.demo_monedero.R
import com.example.tayler_gabbi.demo_monedero.model.Categoria
import kotlinx.android.synthetic.main.molde_categoria.view.*

class AdapterCategoria ( val onClickEditar : ((Categoria) -> Unit)? = null, val onClickEliminar : ((Categoria) -> Unit)? = null ): RecyclerView.Adapter<AdapterCategoria.CategoriaViewHolder>(){

    private var categorias : List<Categoria>? = null

    fun agregarLista (categorias : List<Categoria>){
        this.categorias = categorias

        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.molde_categoria,parent,false)
        return CategoriaViewHolder(view)
    }

    override fun getItemCount(): Int {
        val checkedUser = checkNotNull(categorias){return 0}

        return checkedUser.size
    }

    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
       val categoria = categorias!![position]

        holder.nombreCategoria.text = categoria.Categoria

        holder.editarCategoria.setOnClickListener{

            onClickEditar?.invoke(categoria)
        }

        holder.eliminarcategoria.setOnClickListener {

            onClickEliminar?.invoke(categoria)
        }


    }


    class CategoriaViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val nombreCategoria = itemView.text_view_categoria
        val eliminarcategoria = itemView.image_delete_categoria
        val editarCategoria = itemView.image_edit_categoria

    }

}