package com.example.tayler_gabbi.demo_monedero.database.dao

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.example.tayler_gabbi.demo_monedero.model.Egresos
import com.example.tayler_gabbi.demo_monedero.model.Usuario

interface IngresoDao {
    @Query("select * from Ingresos")
    fun listarIngresos(): List<Usuario>

    @Insert
    fun insert(ingreso: Ingresos): Long

    @Delete
    fun deleteIngreso(ingreso: Ingresos):Int

   
}