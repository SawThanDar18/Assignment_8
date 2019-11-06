package com.example.assignment_8.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.assignment_8.data.vos.PlantVO

@Dao
abstract class PlantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertPlants(plants: List<PlantVO>): LongArray

    @Query("SELECT * FROM plant")
    abstract fun getPlants(): LiveData<List<PlantVO>>

    @Query("SELECT * FROM plant WHERE plant_id=:id")
    abstract fun getPlantsById(id: String): LiveData<PlantVO>

    @Query("SELECT * FROM plant WHERE plant_name LIKE :plant_name")
    abstract fun getPlantsByName(plant_name: String): List<PlantVO>

}