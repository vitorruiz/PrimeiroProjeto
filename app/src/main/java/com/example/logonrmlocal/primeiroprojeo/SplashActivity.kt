package com.example.logonrmlocal.primeiroprojeo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        carregar()
    }

    private fun carregar() {
        Handler().postDelayed({
            chamarProximaTela()
        }, 1000L)
    }

    private fun chamarProximaTela() {
        startActivity(Intent(this, FormularioActivity::class.java))
        finish()
    }
}
