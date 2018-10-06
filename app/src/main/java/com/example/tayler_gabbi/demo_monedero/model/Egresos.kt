package com.example.tayler_gabbi.demo_monedero.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Egresos (

        @PrimaryKey(autoGenerate = true)
        var IdEgreso:Int?=null,

        var categoria:String?="",

        var descripcion:String?="",

        var monto:Int?=0,

        var dia:String?="",

        var mes:String?="",

        var anio:String?=""
)