package com.example.assignment_8.persistence.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.assignment_8.data.vos.FavouriteVO

@Dao
abstract class FavouriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertFavourite(favourite: FavouriteVO): Long

    @Query("SELECT * FROM favourite")
    abstract fun getFavourite(): List<FavouriteVO>

    @Query("SELECT * FROM favourite WHERE image=:image")
    abstract fun getFavourite(image: String): FavouriteVO

}