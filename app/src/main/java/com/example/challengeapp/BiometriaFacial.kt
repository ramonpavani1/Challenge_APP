package com.example.quodsimulator

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.challengeapp.R

class BiometriaFacial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biometria_facial)

        val btnAutenticar = findViewById<Button>(R.id.btnValidate)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val statusMessage = findViewById<TextView>(R.id.statusMessage)

        btnAutenticar.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            statusMessage.visibility = View.VISIBLE
            statusMessage.text = "Analisando face..."

            
            Handler(Looper.getMainLooper()).postDelayed({
                progressBar.visibility = View.GONE
                val success = Validacao()

                if (success) {
                    statusMessage.text = "Usuário autenticado com sucesso!"
                    statusMessage.setTextColor(resources.getColor(android.R.color.holo_green_dark))
                } else {
                    statusMessage.text = "Falha na autenticação."
                    statusMessage.setTextColor(resources.getColor(android.R.color.holo_red_dark))
                }
            }, 3000)
        }
    }

    private fun Validacao(): Boolean {
        return (0..1).random() == 1
    }
}
