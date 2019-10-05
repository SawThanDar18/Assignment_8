package com.example.assignment_8.data

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class UploadUserVO (

    @SerializedName("name")
    @ColumnInfo(name = "name")
    val name: String,

    @SerializedName("user_photo")
    @ColumnInfo(name = "user_photo")
    val user_photo: String,

    @SerializedName("uploaded_time")
    @ColumnInfo(name = "uploaded_time")
    val uploaded_time: String,

    @SerializedName("user_rank")
    @ColumnInfo(name = "user_rank")
    val user_rank: String
)