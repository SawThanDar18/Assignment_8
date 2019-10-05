package com.example.assignment_8.delegates

interface ItemClicked {

    fun onClicked(plant_id: String)

    fun addFavourite(image: String)
}