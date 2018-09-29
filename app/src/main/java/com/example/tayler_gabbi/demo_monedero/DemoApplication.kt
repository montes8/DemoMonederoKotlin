package com.example.tayler_gabbi.demo_monedero

import android.app.Application
import android.arch.persistence.room.Room
import com.example.tayler_gabbi.demo_monedero.database.DataBase

class DemoApplication : Application() {

    companion object {

        var database : DataBase? = null
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(this,DataBase::class.java,"monedero.db")
                .build()
    }
}