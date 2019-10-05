package com.example.assignment_8.activities

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.assignment_8.R
import com.example.assignment_8.data.models.PlantModel
import com.example.assignment_8.data.models.PlantModelImpl
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

abstract class BaseActivity: AppCompatActivity() {

    protected lateinit var plantModel: PlantModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plantModel = PlantModelImpl

    }

    fun showSnackBar(message: String){
        val snackbar = Snackbar.make(window.decorView, message, Snackbar.LENGTH_LONG)
        snackbar.setAction(getString(R.string.snackbar_msg), object : View.OnClickListener {
            override fun onClick(v: View?) {
                snackbar.dismiss()
            }
        })
    }

    fun openDrawer(){
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        /*if (!drawerLayout.isDrawerOpen(GravityCompat.START))
            else drawerLayout.closeDrawer(GravityCompat.END)*/
        drawerLayout.openDrawer(Gravity.LEFT)
    }
}