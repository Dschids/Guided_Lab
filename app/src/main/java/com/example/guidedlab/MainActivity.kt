package com.example.guidedlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    enum class LoginSuccess
        constructor(val intValue: Int){
            login (1),
            password (2),
            success (0)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtLogin = findViewById<EditText>(R.id.idEdtTxtUserName)
        val txtPassword = findViewById<EditText>(R.id.idEdtTxtPassword)
        val btnLogin = findViewById<Button>(R.id.idBtnLogin)
        val nextScreen = Intent(this@MainActivity, MainClassList::class.java)

        btnLogin.setOnClickListener {
            when (CheckLogin(txtLogin.text.toString(), txtPassword.text.toString())) {
                LoginSuccess.login -> {
                    Toast.makeText(applicationContext, getString(R.string.errMsgLogin), Toast.LENGTH_LONG
                    ).show()
                    txtLogin.requestFocus()
                }

                LoginSuccess.password -> {
                    Toast.makeText(applicationContext, getString(R.string.errMsgPassword), Toast.LENGTH_LONG).show()
                    txtPassword.requestFocus()
                }

                else ->
                    startActivity(nextScreen)
            }
        }
    }

    fun CheckLogin(txtLogin: String, txtPassword: String): LoginSuccess {
        val holdLogin = "Bob"
        val holdPass = "12345"

        if (holdLogin != txtLogin) {
            return LoginSuccess.login
        }
        return if (holdPass != txtPassword){
            return LoginSuccess.password
        } else LoginSuccess.success

    }
}