package com.example.tayler_gabbi.demo_monedero.database.dao

import android.arch.persistence.room.*
import com.example.tayler_gabbi.demo_monedero.model.Egresos
import com.example.tayler_gabbi.demo_monedero.model.Usuario

@Dao
interface EgresoDao {

    @Query("select * from Egresos")
    fun listarGastos(): List<Usuario>

    @Insert
    fun insert(egreso: Egresos): Long

    @Delete
    fun deleteUser(egreso: Egresos):Int

    @Update
    fun updateUser(egreso: Egresos)
}