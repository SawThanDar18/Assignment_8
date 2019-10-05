package com.example.assignment_8.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "favourite")
data class FavouriteVO (

    @ColumnInfo(name = "image")
    val image: String
)