package com.example.assignment_8.network.dataagents

import com.example.assignment_8.data.vos.LoginVO
import com.example.assignment_8.data.vos.PlantVO

interface DataAgent {

    fun getPlants(onSuccess: (List<PlantVO>) -> Unit,
                  onFailure: (String) -> Unit)

    fun getAuth(onSuccess: (List<LoginVO>) -> Unit,
                onFailure: (String) -> Unit)
}