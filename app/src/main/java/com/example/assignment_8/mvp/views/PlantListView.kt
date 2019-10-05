package com.example.assignment_8.mvp.views

import com.example.assignment_8.data.vos.PlantVO

interface PlantListView: BaseView {

    fun displayPlantList(plantList: List<PlantVO>)
    fun displayErrorMessage(message: String)
    fun navigateToPlantDetail(plant_id: String)
    fun addFavourite(plant_id: String)
}