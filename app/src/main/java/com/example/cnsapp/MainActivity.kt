package com.example.cnsapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.desapp.DESHelper

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputText = findViewById<EditText>(R.id.inputText)
        val keyText = findViewById<EditText>(R.id.keyText)
        val encryptButton = findViewById<Button>(R.id.encryptButton)
        val decryptButton = findViewById<Button>(R.id.decryptButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        encryptButton.setOnClickListener { v: View? ->
            val text = inputText.text.toString()
            val key = keyText.text.toString()
            if (key.length != 8) {
                resultText.text = "Key must be 8 characters long"
                return@setOnClickListener
            }
            try {
                val encryptedText = DESHelper.encrypt(text, key)
                resultText.text = encryptedText
            } catch (e: Exception) {
                Log.e(TAG, "Encryption error", e)
                resultText.text = "Encryption error: ${e.message}"
            }
        }

        decryptButton.setOnClickListener { v: View? ->
            val text = inputText.text.toString()
            val key = keyText.text.toString()
            if (key.length != 8) {
                resultText.text = "Key must be 8 characters long"
                return@setOnClickListener
            }
            try {
                val decryptedText = DESHelper.decrypt(text, key)
                resultText.text = decryptedText
            } catch (e: Exception) {
                Log.e(TAG, "Decryption error", e)
                resultText.text = "Decryption error: ${e.message}"
            }
        }
    }
}