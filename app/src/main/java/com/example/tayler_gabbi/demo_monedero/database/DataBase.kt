package com.example.tayler_gabbi.demo_monedero.database

import android.arch.persistence.room.Database
import com.example.tayler_gabbi.demo_monedero.database.dao.UsuarioDao
import com.example.tayler_gabbi.demo_monedero.model.Usuario


@Database(entities = [Usuario::class],version = 1)
abstract class DataBase{

    abstract fun usuarioDao() : UsuarioDao

}