package com.example.tayler_gabbi.demo_monedero.database.dao

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.example.tayler_gabbi.demo_monedero.model.Categoria
import com.example.tayler_gabbi.demo_monedero.model.Egresos
import com.example.tayler_gabbi.demo_monedero.model.Usuario

interface CategoriaDao {

    @Query("select * from Categoria")
    fun listarCategorias(): ArrayList<Categoria>

    @Insert
    fun insert(categoria: Categoria): Long

    @Delete
    fun deleteUser(categoria: Categoria):Int

    @Update
    fun updateUser(categoria: Categoria)
}