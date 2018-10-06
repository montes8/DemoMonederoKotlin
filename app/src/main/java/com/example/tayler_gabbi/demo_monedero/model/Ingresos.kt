package com.example.tayler_gabbi.demo_monedero.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity
class Ingresos (
        @PrimaryKey(autoGenerate = true)
        var IdIngreso:Int?=null,

        var descripcion:String?="",

        var monto:Int?=0,

        var dia:String?="",

        var mes:String?="",

        var anio:String?=""
)