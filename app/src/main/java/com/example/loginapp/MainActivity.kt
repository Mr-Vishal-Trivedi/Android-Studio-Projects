package com.example.loginapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    lateinit var edtEmail: EditText
    lateinit var edtPassword: EditText
    lateinit var btnLogin: Button
    lateinit var forgot_password: TextView
    lateinit var go_to_signup: TextView
    lateinit var login_toolbar:Toolbar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtEmail = findViewById(R.id.EmailId)
        edtPassword = findViewById(R.id.Password)
        btnLogin = findViewById(R.id.LoginButton)
        forgot_password = findViewById(R.id.login_forgot_password)
        go_to_signup = findViewById(R.id.go_to_signup)
        login_toolbar = findViewById(R.id.toolbar_login)

        go_to_signup.text = Html.fromHtml("<font color=#807c8d>Don't Have an Account? </font>" +
                "<font color=#0cf3e1> Sign up</font>")

        if (this::edtEmail.isInitialized) {
            Log.d("Debug", "editName has been Initialized...")
        }

        setSupportActionBar(login_toolbar)
    }

    override fun onStart() {
        super.onStart()
        go_to_signup.setOnClickListener() {
            Toast.makeText(this, "Create Account", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

        forgot_password.setOnClickListener() {
            Toast.makeText(this, "Forgot Password Button Clicked", Toast.LENGTH_SHORT).show()
            Log.d("Debug", "Forgot Password Button Clicked")
        }

        btnLogin.setOnClickListener {
            var username: String = edtEmail.text.toString()
            var password: String = edtPassword.text.toString()

            var intent = Intent(this, Welcome::class.java)

            intent.putExtra("username", username)
            intent.putExtra("password", password)

            startActivity(intent)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.meni_layout, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }

            R.id.signup_menu -> {
                Toast.makeText(this, "Signup", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SignUp::class.java)
                startActivity(intent)
            }

            R.id.login_menu -> {
                Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

            R.id.splash_menu -> {
                Toast.makeText(this, "Splash Screen", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SplashLogin::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}