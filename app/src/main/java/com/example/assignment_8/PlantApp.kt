package com.example.assignment_8

import android.app.Application
import com.example.assignment_8.data.models.PlantModelImpl

class PlantApp: Application() {

    override fun onCreate() {
        super.onCreate()

        PlantModelImpl.initDatabase(applicationContext)
    }
}