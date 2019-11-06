package com.example.assignment_8.mvp.presenters

import androidx.lifecycle.Observer
import com.example.assignment_8.activities.BaseActivity
import com.example.assignment_8.data.models.PlantModelImpl
import com.example.assignment_8.mvp.views.PlantDetailView

class PlantDetailPresenter: BasePresenter<PlantDetailView>() {

    fun onUIReady(activity: BaseActivity, plant_id: String){
        if (plant_id != null){
            val model = PlantModelImpl
            model.findById(plant_id)
                .observe(activity, Observer {
                    mView.displayPlantData(it)
                })
        }
    }
}