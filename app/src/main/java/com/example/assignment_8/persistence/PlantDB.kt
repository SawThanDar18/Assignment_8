package com.example.assignment_8.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.assignment_8.data.vos.FavouritePlantVO
import com.example.assignment_8.data.vos.LoginVO
import com.example.assignment_8.data.vos.PlantVO
import com.example.assignment_8.persistence.daos.FavouritePlantDao
import com.example.assignment_8.persistence.daos.LoginDao
import com.example.assignment_8.persistence.daos.PlantDao
import com.example.assignment_8.persistence.typeconverters.TipsTypeConverter
import com.example.assignment_8.persistence.typeconverters.UploadedUserTypeConverter
import com.example.assignment_8.utils.PLANT_DB

@Database(entities = arrayOf(PlantVO::class, FavouritePlantVO::class, LoginVO::class), version = 12, exportSchema = false)
@TypeConverters(TipsTypeConverter::class, UploadedUserTypeConverter::class)
abstract class PlantDB: RoomDatabase(){

    abstract fun plantDao(): PlantDao
    abstract fun favouriteDao(): FavouritePlantDao
    abstract fun loginDao(): LoginDao

    companion object{
        var INSTANCE: PlantDB? = null

        fun getInstance(context: Context): PlantDB {
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context, PlantDB::class.java, PLANT_DB)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }

            return INSTANCE!!
        }
    }
}