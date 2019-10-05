package com.example.assignment_8.data.models

import com.example.assignment_8.data.vos.PlantVO
import java.util.ArrayList

object PlantModelImpl: BaseModel(), PlantModel {

    override fun getPlants(onSuccess: (List<PlantVO>) -> Unit, onFailure: (String) -> Unit) {
        val plantDataFromDB = plantDB.plantDao().getPlants()
        if (plantDataFromDB.isNotEmpty()) {
            onSuccess(plantDataFromDB)
        }else {
            dataAgent.getPlants(
                onSuccess={
                    plantDB.plantDao().insertPlants(it)
                    onSuccess(it)
                },
                onFailure= {

                })
        }
    }

    override fun findById(plant_id: String): PlantVO {
        return plantDB.plantDao().getPlantsById(plant_id)
    }

    override fun getPlantsByName(plant_name: String): List<PlantVO> {
        val plantVO = plantDB.plantDao().getPlants()
        val search_plant = ArrayList<PlantVO>()
        for (plants in plantVO) {
            if (plants.plant_name.toLowerCase().contains(plant_name.toLowerCase())) {
                search_plant.add(plants)
            }
        }
        return search_plant
    }
}
