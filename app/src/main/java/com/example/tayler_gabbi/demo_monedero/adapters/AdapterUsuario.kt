package com.example.tayler_gabbi.demo_monedero.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tayler_gabbi.demo_monedero.R
import com.example.tayler_gabbi.demo_monedero.model.Categoria
import com.example.tayler_gabbi.demo_monedero.model.Usuario
import kotlinx.android.synthetic.main.molde_categoria.view.*
import kotlinx.android.synthetic.main.molde_list_user.view.*

class AdapterUsuario ( val onClickEditarUsuario : ((Usuario) -> Unit)? = null, val onClickEliminarUsuario : ((Usuario) -> Unit)? = null ): RecyclerView.Adapter<AdapterUsuario.UsuarioViewHolder>(){

    private var usuarios : List<Usuario>? = null

    fun agregarLista (usuarios : List<Usuario>){
        this.usuarios = usuarios

        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.molde_categoria,parent,false)
        return UsuarioViewHolder(view)
    }

    override fun getItemCount(): Int {
        val checkedUser = checkNotNull(usuarios){return 0}

        return checkedUser.size
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario = usuarios!![position]

        holder.nombre.text = usuario.nombre
        holder.nombreusuario.text = usuario.nombreUsuario
        holder.contrasenia.text = usuario.contrasenia


        holder.eliminarcategoria.setOnClickListener {

            onClickEliminarUsuario?.invoke(usuario)
        }


    }


    class UsuarioViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val nombre = itemView.text_view_nombre1
        val nombreusuario = itemView.text_view_usuario1
        val contrasenia = itemView.text_view_password1
        val eliminarcategoria = itemView.image_delete_categoria

    }
}