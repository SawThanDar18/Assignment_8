package com.example.assignment_8.persistence.typeconverters

import androidx.room.TypeConverter
import com.example.assignment_8.data.TipsVO
import com.example.assignment_8.data.vos.PlantVO
import com.google.gson.Gson

class TipsTypeConverter {

    @TypeConverter
    fun tipsToJson(tipsVO: TipsVO): String {
        return Gson().toJson(tipsVO)
    }


    @TypeConverter
    fun jsonToTips(tips: String): TipsVO {
        return Gson().fromJson(tips, TipsVO::class.java)
    }
}