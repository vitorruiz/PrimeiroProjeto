package com.example.logonrmlocal.primeiroprojeo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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
                return@setOnClickListener
            }

            val peso = txt_peso.text.toString().toDouble()
            val altura = txt_altura.text.toString().toDouble()

            txt_imc.text = "Seu IMC é: ${(peso / (altura * altura)) * 10000}"
        }
    }
}
