package com.example.assignment_8.workers

import android.content.Context
import androidx.work.WorkerParameters

class GetPlantWorker(context: Context, workerParams: WorkerParameters): BaseWorker(context, workerParams) {

    override fun doWork(): Result {
        var result: Result = Result.failure()
        dataAgent.getPlants(onSuccess = {
            plantDB.plantDao().insertPlants(it)
            result = Result.success()
        }, onFailure = {
            result = Result.failure()
        })
        return result
    }
}