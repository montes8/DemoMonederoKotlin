package com.example.tayler_gabbi.demo_monedero.database.dao

import android.arch.persistence.room.*
import com.example.tayler_gabbi.demo_monedero.model.Categoria
import com.example.tayler_gabbi.demo_monedero.model.Egresos
import com.example.tayler_gabbi.demo_monedero.model.Usuario

@Dao
interface CategoriaDao {

    @Query("select * from Categoria")
    fun listarCategorias(): List<Categoria>

    @Insert
    fun insert(categoria: Categoria): Long

    @Delete
    fun deleteUser(categoria: Categoria):Int

    @Update
    fun updateUser(categoria: Categoria)
}