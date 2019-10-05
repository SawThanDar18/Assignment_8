package com.example.assignment_8.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.assignment_8.R
import com.example.assignment_8.data.vos.PlantVO
import com.example.assignment_8.delegates.ItemClicked
import com.example.assignment_8.viewHolders.FavouriteItemViewHolder

class FavouriteItemAdapter(private val delegate: ItemClicked): BaseAdapter<FavouriteItemViewHolder, PlantVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteItemViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.favourite_item_view, parent, false)
        return FavouriteItemViewHolder(layout, delegate)
    }
}