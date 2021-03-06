package com.example.tayler_gabbi.demo_monedero.database.dao

import android.arch.persistence.room.*
import com.example.tayler_gabbi.demo_monedero.model.Usuario

@Dao
interface UsuarioDao {

    @Query("select * from Usuario")
    fun listarUsuario(): List<Usuario>

    @Query("select * from Usuario where nombreUsuario = :name and contrasenia = :pass")
    fun userLogin(name:String,pass:String):Usuario

    @Query("select * from Usuario where idUsu = :id")
    fun verDetalleUsuarioLogeado(id : Long ): Usuario


    @Insert
    fun insert(usuarios: Usuario): Long

    @Delete
    fun deleteUser(usuarios: Usuario):Int

    @Update
    fun updateUser(usuarios: Usuario)
}