package com.example.assignment_8.data.models

import com.example.assignment_8.data.vos.PlantVO

interface PlantModel {

    fun getPlants(onSuccess: (List<PlantVO>) -> Unit,
                  onFailure: (String) -> Unit)

    fun findById(plant_id: String) : PlantVO

    fun getPlantsByName(plant_name: String): List<PlantVO>

}