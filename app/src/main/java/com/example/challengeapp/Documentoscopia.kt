package com.example.challengeapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Documentoscopia : AppCompatActivity() {

    private lateinit var statusMessage: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var btnValidate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_documentoscopia)

        statusMessage = findViewById(R.id.statusMessage)
        progressBar = findViewById(R.id.progressBar)
        btnValidate = findViewById(R.id.btnValidate)

        btnValidate.setOnClickListener {
            DocumentoValidacao()
        }
    }

    private fun DocumentoValidacao() {
        statusMessage.visibility = View.VISIBLE
        progressBar.visibility = View.VISIBLE
        statusMessage.text = "Validando documento..."

        // Simulação de validação de documento
        progressBar.postDelayed({
            statusMessage.text = "Documento validado com sucesso!"
            progressBar.visibility = View.GONE
        }, 3000)
    }
}
