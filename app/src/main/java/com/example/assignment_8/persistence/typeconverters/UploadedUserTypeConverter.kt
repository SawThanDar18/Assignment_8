package com.example.assignment_8.persistence.typeconverters

import androidx.room.TypeConverter
import com.example.assignment_8.data.UploadUserVO
import com.google.gson.Gson

class UploadedUserTypeConverter {

    @TypeConverter
    fun uploadedUserToJson(uploadUserVO: UploadUserVO): String {
        return Gson().toJson(uploadUserVO)
    }

    @TypeConverter
    fun jsonToUploadedUser(uploadedUser: String): UploadUserVO {
        return Gson().fromJson(uploadedUser, UploadUserVO::class.java)
    }
}