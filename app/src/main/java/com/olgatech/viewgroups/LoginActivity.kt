package com.olgatech.viewgroups

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible

class LoginActivity : AppCompatActivity() {
    lateinit var emailEt : EditText
    lateinit var passwordEt : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailEt = findViewById(R.id.etEmail)
        passwordEt  = findViewById(R.id.etPassword)
        val button:Button = findViewById(R.id.loginBtn)
        val progressBar =findViewById<ProgressBar>(R.id.progressBar)
        retrieveData()

        button.setOnClickListener {
            progressBar.isVisible = true
            storeData()
        }
    }

    private fun storeData() {
        if (emailEt.text.isEmpty()){
            emailEt.error = "Enter email address"
            return
        }
         else if (passwordEt.text.isEmpty()){
             passwordEt.error = "Enter password"
            return
        }

        val pref = getSharedPreferences("dataSupplied", Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString("email", emailEt.text.toString())
        editor.putString("password", passwordEt.text.toString())
        editor.apply()

        Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun retrieveData() {
        val mypref = getSharedPreferences("dataRetrieved", Context.MODE_PRIVATE)
        val email = mypref.getString("email", "")
        val password = mypref.getString("password", "")
        emailEt.setText(email)
        passwordEt.setText(password)
    }


}