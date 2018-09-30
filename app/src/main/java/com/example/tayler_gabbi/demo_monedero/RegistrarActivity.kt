package com.example.tayler_gabbi.demo_monedero

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.example.tayler_gabbi.demo_monedero.model.Usuario
import kotlinx.android.synthetic.main.activity_registrar.*
import org.jetbrains.anko.*

class RegistrarActivity : AppCompatActivity() {

    var handler : Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)
    }

    private fun ajusteToolbar() {
        setSupportActionBar(toolbar_register)
        title = " REGISTRATE "
        toolbar_register.navigationIcon = getDrawable(R.drawable.ic_flecha_back)
        toolbar_register.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun registrarUsuario() {
        button_register_ingresar.setOnClickListener {


            Thread {

                if (edit_text_name.text.toString().isEmpty()) {

                    handler.post { toast("ingrese nombre") }

                }else if(edit_text_usuario.text.toString().isEmpty()){
                    handler.post { toast("Ingrese nombre de usuario") }

                }else if(edit_text_password.text.toString().isEmpty()){
                    handler.post { toast("Ingrese contraseña") }

                }else {
                    val usuario = Usuario()
                    usuario.nombre = edit_text_name.text.toString()
                    usuario.nombreUsuario = edit_text_usuario.text.toString()
                    usuario.contrasenia = edit_text_password.text.toString()

                    val nuevoId = DemoApplication.database!!.usuarioDao().insert(usuario)
                    if (nuevoId > 0) {
                        Log.i("idregistrado", "$nuevoId")
                        handler.post {
                            toast("Usuario Registrado")
                            edit_text_name.setText("")
                            edit_text_usuario.setText("")
                            edit_text_password.setText("")

                            startActivity(intentFor<NavegacionActivity>().newTask().clearTask())
                        }
                    } else {
                        handler.post { toast("errorrrr") }
                    }
                }
            }.start()

        }
    }
}
