package com.example.assignment_8.data.models

import androidx.lifecycle.LiveData
import com.example.assignment_8.data.vos.FavouritePlantVO
import com.example.assignment_8.data.vos.PlantVO

interface PlantModel {

    fun getPlants(onFailure: (String) -> Unit): LiveData<List<PlantVO>>

    fun findById(plant_id: String) : LiveData<PlantVO>

    fun getPlantsByName(plant_name: String): List<PlantVO>

    fun addFavouritePlant(favouritePlantVO: FavouritePlantVO)

    fun getFavouritePlant(onSuccess: (List<PlantVO>) -> Unit,
                          onFailure: (String) -> Unit)

    fun getFavouritePlantById(plant_id: String): FavouritePlantVO

    fun deleteFavouritePlant(favouritePlantVO: FavouritePlantVO)
}