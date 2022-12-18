package com.example.loginapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar

@Suppress("DEPRECATION")
class SignUp : AppCompatActivity() {

    lateinit var goto_login: TextView
    lateinit var sign_toolbar: androidx.appcompat.widget.Toolbar
    lateinit var signup_button: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        goto_login = findViewById(R.id.go_to_login)
        sign_toolbar = findViewById(R.id.toolbar_signup)
        signup_button = findViewById(R.id.signup_button)

        goto_login.text = Html.fromHtml("<font color=#807c8d>Already Have an Account? </font>" +
                "<font color=#0cf3e1> Log in</font>")

        setSupportActionBar(this.sign_toolbar)

    }

    override fun onStart() {
        super.onStart()
        goto_login.setOnClickListener() {
            Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        signup_button.setOnClickListener() {
            Toast.makeText(this, "Registered Successfully!!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
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