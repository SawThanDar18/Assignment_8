package com.example.assignment_8.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.assignment_8.R
import com.example.assignment_8.data.vos.PlantVO
import com.example.assignment_8.delegates.ItemClicked
import com.example.assignment_8.viewHolders.PlantItemViewHolder

class PlantItemAdapter(private val delegate: ItemClicked): BaseAdapter<PlantItemViewHolder, PlantVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantItemViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.home_item_view, parent, false)
        return PlantItemViewHolder(layout, delegate)
    }
}