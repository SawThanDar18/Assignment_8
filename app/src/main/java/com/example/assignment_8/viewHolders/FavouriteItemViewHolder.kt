package com.example.assignment_8.viewHolders

import android.view.View
import com.bumptech.glide.Glide
import com.example.assignment_8.data.vos.PlantVO
import com.example.assignment_8.delegates.ItemClicked
import kotlinx.android.synthetic.main.favourite_item_view.view.*
import kotlinx.android.synthetic.main.item_detail_image.view.*

class FavouriteItemViewHolder(itemView: View, private val delegate: ItemClicked): BaseViewHolder<PlantVO>(itemView) {

    init {
        itemView.setOnClickListener {
            data?.plant_id?.let {plant_id ->
                delegate.onClicked(plant_id, itemView.favourite_iv)
            }
        }
    }

    override fun bindData(data: PlantVO) {
        Glide.with(itemView.favourite_iv).load(data.plant_photo).into(itemView.favourite_iv)
    }
}