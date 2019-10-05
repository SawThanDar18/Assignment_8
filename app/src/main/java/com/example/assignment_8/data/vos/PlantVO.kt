package com.example.assignment_8.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.assignment_8.data.TipsVO
import com.example.assignment_8.data.UploadUserVO
import com.google.gson.annotations.SerializedName

@Entity(tableName = "plant")
data class PlantVO (

    @PrimaryKey
    @SerializedName("plant_id")
    @ColumnInfo(name = "plant_id")
    var plant_id: String,

    @SerializedName("plant_name")
    @ColumnInfo(name = "plant_name")
    var plant_name: String,

    @SerializedName("description")
    @ColumnInfo(name = "description")
    var description: String,

    @SerializedName("top_tip")
    @ColumnInfo(name = "top_tip")
    var top_tip: String,

    @SerializedName("tips")
    var tipsVO: TipsVO,

    @SerializedName("uploaded_user")
    var uploadUserVO: UploadUserVO,

    @SerializedName("plant_photo")
    @ColumnInfo(name = "plant_photo")
    var plant_photo: String

    )