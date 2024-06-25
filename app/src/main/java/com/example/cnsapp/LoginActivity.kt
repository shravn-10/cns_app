package com.example.cnsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.login)

        // Hardcoded credentials
        val validEmail = "user@example.com"
        val validPassword = "password123"

        loginButton.setOnClickListener {
            val emailText = email.text.toString()
            val passwordText = password.text.toString()

            if (emailText == validEmail && passwordText == validPassword) {
                // Credentials match, proceed to MainActivity
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                // Credentials do not match, show error
                Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
