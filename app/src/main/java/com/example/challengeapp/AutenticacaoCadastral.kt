package com.example.challengeapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AutenticacaoCadastral : AppCompatActivity() {

    private lateinit var inputCPF: EditText
    private lateinit var inputName: EditText
    private lateinit var inputEmail: EditText
    private lateinit var inputPhone: EditText
    private lateinit var btnSubmit: Button
    private lateinit var scoreResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autenticacao_cadastral)

        inputCPF = findViewById(R.id.inputCPF)
        inputName = findViewById(R.id.inputName)
        inputEmail = findViewById(R.id.inputEmail)
        inputPhone = findViewById(R.id.inputPhone)
        btnSubmit = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            simulateCadastroValidation()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun simulateCadastroValidation() {
        val cpf = inputCPF.text.toString()
        val name = inputName.text.toString()
        val email = inputEmail.text.toString()
        val phone = inputPhone.text.toString()

        if (cpf.isNotEmpty() && name.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty()) {
            Toast.makeText(this, "Autenticação Cadastral realizada com sucesso!", Toast.LENGTH_SHORT).show()
            scoreResult.text = "Cadastro validado!"
        } else {
            Toast.makeText(this, "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show()
        }
    }
}
