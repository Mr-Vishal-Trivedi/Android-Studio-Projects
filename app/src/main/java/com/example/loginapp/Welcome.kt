package com.example.loginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.widget.Toolbar


class Welcome : AppCompatActivity() {
    lateinit var displayInfo: TextView
    lateinit var welcome_toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_new)

        displayInfo = findViewById(R.id.displayInfo)
        welcome_toolbar = findViewById(R.id.welcome_toolbar)


        var username: String = getIntent().getStringExtra("username").toString()
        var password: String = getIntent().getStringExtra("password").toString()
        Log.d("debug", "This is username : $username and password $password")

        displayInfo.setText("Hello $username !!! \nThis Is Your Password : $password")

        setSupportActionBar(welcome_toolbar)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}