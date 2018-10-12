package com.example.tayler_gabbi.demo_monedero.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Categoria (

        @PrimaryKey(autoGenerate = true)
        var IdCategoria:Long?=null,

        var Categoria : String = ""
)