package com.example.assignment_8.mvp.views

import com.example.assignment_8.data.vos.PlantVO

interface FavouritePlantListView: BaseView {

    fun displayFavouritePlantList(plantVO: List<PlantVO>)
    fun displayErrorMessage(message: String)
    fun navigateToPlantDetail(plant_id: String)
}