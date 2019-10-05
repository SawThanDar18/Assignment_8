package com.example.assignment_8.data.vos

import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "favourite_plants",
    foreignKeys = [ForeignKey(entity = PlantVO::class, parentColumns = ["plant_id"], childColumns = ["favourite_plant_id"], onDelete = ForeignKey.NO_ACTION)],
    indices = [Index(value = ["favourite_plant_id"], unique = true)])

data class FavouritePlantVO (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "favourite_plant_id")
    val favourite_plant_id: String
)