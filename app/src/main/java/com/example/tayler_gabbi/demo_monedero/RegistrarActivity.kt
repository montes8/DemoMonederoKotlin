package com.example.tayler_gabbi.demo_monedero

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.*

class RegistrarActivity : AppCompatActivity() {

    var handler : Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)
    }

    fun logearse(){
        button_ingresar.setOnClickListener {

            Thread{
                val usuario= DemoApplication.database?.usuarioDao()?.userLogin(edit_usuario.text.toString(),edit_pasword.text.toString())

                if (usuario!=null){
                    handler.post {
                        toast("Bienvenida (o) ${usuario?.nombreUsuario}")
                        startActivity(intentFor<CategoriaActivity>().newTask().clearTask())
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
