package com.example.tayler_gabbi.demo_monedero

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.tayler_gabbi.demo_monedero.view.LoginActivity
import com.example.tayler_gabbi.demo_monedero.view.RegistrarActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_sesion.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        button_register.setOnClickListener{
            val intent = Intent(this, RegistrarActivity::class.java)
            startActivity(intent)
        }
    }
}
