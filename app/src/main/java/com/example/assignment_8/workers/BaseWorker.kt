package com.example.assignment_8.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.assignment_8.network.dataagents.DataAgent
import com.example.assignment_8.network.dataagents.RetrofitDataAgentImpl
import com.example.assignment_8.persistence.PlantDB

abstract class BaseWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    protected val dataAgent: DataAgent = RetrofitDataAgentImpl

    protected val plantDB: PlantDB = PlantDB.getInstance(context)
}