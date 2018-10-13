package com.example.tayler_gabbi.demo_monedero.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.tayler_gabbi.demo_monedero.database.dao.CategoriaDao
import com.example.tayler_gabbi.demo_monedero.database.dao.EgresoDao
import com.example.tayler_gabbi.demo_monedero.database.dao.UsuarioDao
import com.example.tayler_gabbi.demo_monedero.model.Categoria
import com.example.tayler_gabbi.demo_monedero.model.Egresos
import com.example.tayler_gabbi.demo_monedero.model.Ingresos
import com.example.tayler_gabbi.demo_monedero.model.Usuario


@Database(entities = [Usuario::class,Egresos::class,Categoria::class,Ingresos::class],version = 1)
abstract class DataBase :RoomDatabase(){

    abstract fun usuarioDao() : UsuarioDao
    abstract fun egresoDao() : EgresoDao
    abstract fun categoriaDao() : CategoriaDao

}