package com.example.assignment_8.network.dataagents

import com.example.assignment_8.data.vos.LoginVO
import com.example.assignment_8.data.vos.PlantVO
import com.example.assignment_8.network.responses.GetLoginResponse
import com.example.assignment_8.network.responses.GetPlantResponse
import com.example.assignment_8.network.responses.LoginApi
import com.example.assignment_8.network.responses.PlantApi
import com.example.assignment_8.utils.BASE_URL
import com.example.assignment_8.utils.EM_NULL_RESPONSE
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitDataAgentImpl: DataAgent {

    private val plantApi: PlantApi
    private val loginApi: LoginApi

    init {
        var okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()

        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        plantApi = retrofit.create(PlantApi::class.java)
        loginApi = retrofit.create(LoginApi::class.java)
    }

    override fun getPlants(onSuccess: (List<PlantVO>) -> Unit, onFailure: (String) -> Unit) {
        plantApi.getAllPlants().enqueue(object: Callback<GetPlantResponse>{
            override fun onFailure(call: Call<GetPlantResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(call: Call<GetPlantResponse>, plantResponse: Response<GetPlantResponse>) {
                val response = plantResponse.body()
                if (response!= null) {
                    if (response.data != null) {
                        onSuccess(response.data)
                    } else {
                        onFailure(response.message)
                    }
                }else{
                    onFailure(EM_NULL_RESPONSE)
                }
            }

        })
    }

    override fun getAuth(onSuccess: (List<LoginVO>) -> Unit, onFailure: (String) -> Unit) {
        /*loginApi.getAuth("john@gmail.com", "123456").enqueue(object: Callback<GetLoginResponse>{
            override fun onFailure(call: Call<GetLoginResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(call: Call<GetLoginResponse>, plantResponse: Response<GetLoginResponse>) {
                val response = plantResponse.body()
                if (response!= null) {
                    if (response.loginData != null) {
                        onSuccess(response.loginData)
                    } else {
                        onFailure(response.message)
                    }
                }else{
                    onFailure(EM_NULL_RESPONSE)
                }
            }

        })*/
    }
}