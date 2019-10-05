package com.example.assignment_8.mvp.presenters

import com.example.assignment_8.data.models.PlantModelImpl
import com.example.assignment_8.data.vos.PlantVO
import com.example.assignment_8.mvp.views.PlantDetailView

class PlantDetailPresenter: BasePresenter<PlantDetailView>() {

    fun onUIReady(plant_id: String){
        if (plant_id != null){
            val model = PlantModelImpl
            val plantVO: PlantVO = model.findById(plant_id)
            mView.displayPlantData(plantVO)
        }
    }
}