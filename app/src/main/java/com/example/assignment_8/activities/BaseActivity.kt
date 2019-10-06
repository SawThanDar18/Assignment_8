package com.example.assignment_8.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment_8.R
import com.example.assignment_8.data.models.LoginModel
import com.example.assignment_8.data.models.LoginModelImpl
import com.example.assignment_8.data.models.PlantModel
import com.example.assignment_8.data.models.PlantModelImpl
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity: AppCompatActivity() {

    protected lateinit var plantModel: PlantModel
    protected lateinit var loginModel: LoginModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plantModel = PlantModelImpl
        loginModel = LoginModelImpl

    }

    fun showSnackBar(message: String){
        val snackbar = Snackbar.make(window.decorView, message, Snackbar.LENGTH_LONG)
        snackbar.setAction(getString(R.string.snackbar_msg), object : View.OnClickListener {
            override fun onClick(v: View?) {
                snackbar.dismiss()
            }
        })
    }
}