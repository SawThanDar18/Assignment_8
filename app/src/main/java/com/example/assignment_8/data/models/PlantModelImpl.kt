package com.example.assignment_8.data.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.assignment_8.data.vos.FavouritePlantVO
import com.example.assignment_8.data.vos.PlantVO

object PlantModelImpl: BaseModel(), PlantModel {

    override fun getPlants(onFailure: (String) -> Unit): LiveData<List<PlantVO>> {
        return Transformations.distinctUntilChanged(plantDB.plantDao().getPlants())
    }

    override fun findById(plant_id: String): LiveData<PlantVO> {
        return Transformations.distinctUntilChanged(plantDB.plantDao().getPlantsById(plant_id))
    }

    override fun getPlantsByName(plant_name: String): List<PlantVO> {
        /*val plantVO = plantDB.plantDao().getAll()
        val search_plant = ArrayList<PlantVO>()
        for (plants in plantVO) {
            if (plants.plant_name.toLowerCase().contains(plant_name.toLowerCase())) {
                search_plant.add(plants)
            }
        }*/
        return plantDB.plantDao().getPlantsByName("%$plant_name%")
    }

    override fun getFavouritePlant(onSuccess: (List<PlantVO>) -> Unit, onFailure: (String) -> Unit) {
        val plantDataFromDB = plantDB.favouriteDao().getFavouritePlants()
        if (plantDataFromDB.isNotEmpty()){
            onSuccess(plantDataFromDB)
        }else{
            onFailure
        }
    }

    override fun addFavouritePlant(favouritePlantVO: FavouritePlantVO) {
        plantDB.favouriteDao().insertFavourite(favouritePlantVO)
    }

    override fun getFavouritePlantById(plant_id: String): FavouritePlantVO {
        return plantDB.favouriteDao().getFavouritePlantById(plant_id)
    }

    override fun deleteFavouritePlant(favouritePlantVO: FavouritePlantVO) {
        plantDB.favouriteDao().deleteFavouritePlant(favouritePlantVO)
    }
}
