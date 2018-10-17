package com.example.tayler_gabbi.demo_monedero.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.tayler_gabbi.demo_monedero.model.Ingresos

@Dao
interface IngresoDao {
    @Query("select * from Ingresos")
    fun listarIngresos(): List<Ingresos>

    @Insert
    fun insert(ingreso: Ingresos): Long

    @Delete
    fun deleteIngreso(ingreso: Ingresos):Int


}