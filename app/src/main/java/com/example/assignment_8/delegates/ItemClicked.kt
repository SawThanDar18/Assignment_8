package com.example.assignment_8.delegates

import android.widget.ImageView

interface ItemClicked {

    fun onClicked(plant_id: String, plantImageView: ImageView)

    fun addFavourite(id: String, toggleStatus: Boolean)
}