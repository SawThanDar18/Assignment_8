package com.example.assignment_8

import android.app.Application
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.assignment_8.data.models.PlantModelImpl
import com.example.assignment_8.workers.GetPlantWorker

class PlantApp: Application() {

    override fun onCreate() {
        super.onCreate()

        PlantModelImpl.initDatabase(applicationContext)
        getPlantsOneTime()

    }

    private fun getPlantsOneTime(){
        val getPlantWorkRequest = OneTimeWorkRequest
            .Builder(GetPlantWorker::class.java)
            .build()

        WorkManager.getInstance(applicationContext)
            .enqueue(getPlantWorkRequest)
    }
}