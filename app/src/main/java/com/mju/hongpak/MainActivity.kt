package com.mju.hongpak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val doLogin = findViewById<View>(R.id.auth_button)
        doLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val doExit = findViewById<View>(R.id.exit_btn)
        doExit.setOnClickListener {
            finish()
        }
    }
}