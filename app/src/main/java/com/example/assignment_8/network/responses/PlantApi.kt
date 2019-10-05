package com.example.assignment_8.network.responses

import com.example.assignment_8.utils.GET_PLANTS
import retrofit2.Call
import retrofit2.http.POST

interface PlantApi {

    @POST(GET_PLANTS)
    fun getAllPlants(): Call<GetPlantResponse>

}