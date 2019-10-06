package com.example.assignment_8.activities

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment_8.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_login)

        userName_et.text = "john@gmail.com"

        login_btn.setOnClickListener {
            startActivity(Intent(this, PlantListActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()

    }
}