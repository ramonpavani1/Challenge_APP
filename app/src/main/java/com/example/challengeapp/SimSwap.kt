package com.example.challengeapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SimSwap : AppCompatActivity() {

    private lateinit var statusMessage: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var btnValidate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sim_swap)

        statusMessage = findViewById(R.id.statusMessage)
        progressBar = findViewById(R.id.progressBar)
        btnValidate = findViewById(R.id.btnValidate)

        btnValidate.setOnClickListener {
            SimSwapValidacao()
        }
    }

    private fun SimSwapValidacao() {
        statusMessage.visibility = View.VISIBLE
        progressBar.visibility = View.VISIBLE
        statusMessage.text = "Verificando troca de chip..."

        
        progressBar.postDelayed({
            statusMessage.text = "Troca de chip verificada com sucesso!"
            progressBar.visibility = View.GONE
        }, 3000)
    }
}
