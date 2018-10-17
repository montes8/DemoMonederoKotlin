package com.example.tayler_gabbi.demo_monedero.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.tayler_gabbi.demo_monedero.DemoApplication
import com.example.tayler_gabbi.demo_monedero.R
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.clearTask
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.newTask
import org.jetbrains.anko.toast

class LoginActivity : AppCompatActivity() {

    var handler : Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(toolbar_login)
        toolbar_login.navigationIcon = getDrawable(R.drawable.ic_atras)
        toolbar_login.setOnClickListener{
            onBackPressed()
        }

        logearse()
    }

    fun logearse(){
        button_ingresar.setOnClickListener {

            Thread{
                val usuario= DemoApplication.database?.usuarioDao()?.userLogin(edit_usuario.text.toString(),edit_pasword.text.toString())

                if (usuario!=null){
                    handler.post {
                        toast("Bienvenida (o) ${usuario?.nombreUsuario}")
                        startActivity(intentFor<NavegacionActivity>().newTask().clearTask())
                    }
                }else {
                    handler.post {
                        toast("Usuario o Contraseña Incorrectos")
                    }
                }
            }.start()

        }

    }
}
