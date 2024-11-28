package com.example.challengeapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.quodsimulator.BiometriaFacial

class MainActivity : AppCompatActivity() {

    private lateinit var menuSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        menuSpinner = findViewById(R.id.menuSpinner)

        val options = listOf(
            "Selecione uma opção",
            "Biometria Facial",
            "Biometria Digital",
            "Documentoscopia",
            "SIM Swap",
            "Autenticação Cadastral",
            "Score Antifraude"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        menuSpinner.adapter = adapter

        menuSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    1 -> navegarAtividade(BiometriaFacial::class.java)
                    2 -> navegarAtividade(BiometriaDigital::class.java)
                    3 -> navegarAtividade(Documentoscopia::class.java)
                    4 -> navegarAtividade(SimSwap::class.java)
                    5 -> navegarAtividade(AutenticacaoCadastral::class.java)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

    private fun navegarAtividade(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }
}
