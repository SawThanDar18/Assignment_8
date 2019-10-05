package com.example.assignment_8.data.vos

import com.google.gson.annotations.SerializedName

data class LoginVO(

    @SerializedName("user_id")
    val user_id: Int,

    @SerializedName("user_name")
    val user_name: String,

    @SerializedName("user_photo_url")
    val user_photo_url: String
)