package com.example.logonrmlocal.primeiroprojeo

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.example.logonrmlocal.primeiroprojeo.extension.format
import com.example.logonrmlocal.primeiroprojeo.utils.ConstantsExtra
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val peso = intent.extras.getString(ConstantsExtra.KEY_PESO).toDouble()
        val altura = intent.extras.getString(ConstantsExtra.KEY_ALTURA).toDouble()

        calcularImc(peso, altura)
    }

    private fun calcularImc(peso: Double, altura: Double) {
        val imc = peso / (altura * altura)

        txtIMCValue.text = imc.format(1)

        when (imc) {
            in 0..17 -> {
                txtIMCDescription.text = "Magreza"
                setIMCImage(R.drawable.magreza)
            }
            in 17.0..18.5 -> {
                txtIMCDescription.text = "Abaixo do Peso"
                setIMCImage(R.drawable.abaixo)
            }
            in 18.5..24.9 -> {
                txtIMCDescription.text = "Peso Ideal"
                setIMCImage(R.drawable.ideal)
            }
            in 24.9..29.9 -> {
                txtIMCDescription.text = "Sobrepeso"
                setIMCImage(R.drawable.sobre)
            }
            in 29.9..34.9 -> {
                txtIMCDescription.text = "Obesidade Grau I"
                setIMCImage(R.drawable.obesidade)
            }
            in 34.9..39.9 -> {
                txtIMCDescription.text = "Obesidade Grau II"
                setIMCImage(R.drawable.obesidade)
            }
            else -> {
                txtIMCDescription.text = "Obesidade Grau III"
                setIMCImage(R.drawable.obesidade)
            }
        }
    }

    private fun setIMCImage(resId: Int) {
        imvIMC.setImageDrawable(ContextCompat.getDrawable(this, resId))
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
