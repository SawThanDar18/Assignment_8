package com.example.assignment_8.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "login")
data class LoginVO(

    @PrimaryKey
    @SerializedName("user_id")
    @ColumnInfo(name = "user_id")
    val user_id: String,

    @SerializedName("user_name")
    @ColumnInfo(name = "user_name")
    val user_name: String,

    @SerializedName("user_photo_url")
    @ColumnInfo(name = "user_photo_url")
    val user_photo_url: String,

    @SerializedName("member_since")
    @ColumnInfo(name = "member_since")
    val member_since: String,

    @SerializedName("member_rank")
    @ColumnInfo(name = "member_rank")
    val member_rank: String
)