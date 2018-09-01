package com.example.logonrmlocal.primeiroprojeo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.logonrmlocal.primeiroprojeo.extension.value
import com.example.logonrmlocal.primeiroprojeo.utils.ConstantsExtra
import kotlinx.android.synthetic.main.activity_formulario.*

class FormularioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        setUpView()
    }

    private fun setUpView() {
        btn_limpar.setOnClickListener({
            txt_altura.text.clear()
            txt_peso.text.clear()
        })

        btn_calcular.setOnClickListener {

            if (txt_peso.text.isNullOrEmpty() || txt_altura.text.isNullOrEmpty()) {
                Toast.makeText(this, "Todos os campos são obrigatórios", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            chamaTelaResultado()
        }
    }

    private fun chamaTelaResultado() {
        var i = Intent(this, ResultadoActivity::class.java)
        i.putExtra(ConstantsExtra.KEY_PESO, txt_peso.value())
        i.putExtra(ConstantsExtra.KEY_ALTURA, txt_altura.value())

        startActivity(i)
    }
}
