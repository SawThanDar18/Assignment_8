package com.example.assignment_8.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.assignment_8.data.vos.FavouritePlantVO
import com.example.assignment_8.data.vos.PlantVO

@Dao
abstract class FavouritePlantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertFavourite(favouritePlant: FavouritePlantVO): Long

    @Query("SELECT plant.* FROM plant INNER JOIN favourite_plants WHERE favourite_plant_id == plant_id")
    abstract fun getFavouritePlants(): List<PlantVO>

    @Query("SELECT * FROM favourite_plants WHERE favourite_plant_id=:plant_id")
    abstract fun getFavouritePlantById(plant_id: String): FavouritePlantVO

    @Delete
    abstract fun deleteFavouritePlant(favouritePlantVO: FavouritePlantVO)

}