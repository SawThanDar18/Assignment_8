package com.example.assignment_8.data.models

import android.content.Context
import com.example.assignment_8.network.dataagents.DataAgent
import com.example.assignment_8.network.dataagents.RetrofitDataAgentImpl
import com.example.assignment_8.persistence.PlantDB

abstract class BaseModel {

    protected val dataAgent: DataAgent = RetrofitDataAgentImpl

    protected lateinit var plantDB: PlantDB

    fun initDatabase(context: Context){
        plantDB = PlantDB.getInstance(context)
    }
}