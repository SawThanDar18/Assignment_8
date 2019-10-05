package com.example.assignment_8.network.responses

import com.example.assignment_8.utils.GET_LOGIN
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginApi {

    @POST(GET_LOGIN)
    fun getAuth(@Query("email") email: String,
                @Query("password") password: String): Call<GetPlantResponse>
}