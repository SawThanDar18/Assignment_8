package com.example.assignment_8.activities

import android.os.Bundle
import android.view.WindowManager
import com.example.assignment_8.R

class ProfileActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_profile)

    }
}





















































