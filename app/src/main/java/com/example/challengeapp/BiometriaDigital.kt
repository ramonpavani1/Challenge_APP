package com.example.challengeapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BiometriaDigital : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biometria_digital)

        val btnAutenticar = findViewById<Button>(R.id.btnValidate)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val statusMessage = findViewById<TextView>(R.id.statusMessage)

        btnAutenticar.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            statusMessage.visibility = View.VISIBLE
            statusMessage.text = "Capturando impressão digital..."

            Handler(Looper.getMainLooper()).postDelayed({
                progressBar.visibility = View.GONE
                val success = Validacao()

                if (success) {
                    statusMessage.text = "Biometria validada com sucesso!"
                    statusMessage.setTextColor(resources.getColor(android.R.color.holo_green_dark))
                } else {
                    statusMessage.text = "Erro na validação da biometria."
                    statusMessage.setTextColor(resources.getColor(android.R.color.holo_red_dark))
                }
            }, 3000)
        }
    }

    private fun Validacao(): Boolean {
        return (0..1).random() == 1
    }
}
