package com.example.tayler_gabbi.demo_monedero.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Usuario (

        @PrimaryKey(autoGenerate = true)
        var idUsu : Long? = null,

        var nombre : String = "",

        var nombreUsuario : String = "",

        var contrasenia : String = ""
)