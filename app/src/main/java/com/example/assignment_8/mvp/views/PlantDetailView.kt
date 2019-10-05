package com.example.assignment_8.mvp.views

import com.example.assignment_8.data.vos.PlantVO

interface PlantDetailView: BaseView {
    fun displayPlantData(data: PlantVO)
}