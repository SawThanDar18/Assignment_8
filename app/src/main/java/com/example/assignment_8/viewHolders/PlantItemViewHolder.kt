package com.example.assignment_8.viewHolders

import android.view.View
import com.bumptech.glide.Glide
import com.example.assignment_8.data.vos.PlantVO
import com.example.assignment_8.delegates.ItemClicked
import kotlinx.android.synthetic.main.home_item_view.view.*

class PlantItemViewHolder(itemView: View, private val delegate: ItemClicked): BaseViewHolder<PlantVO>(itemView) {

    init {
        itemView.setOnClickListener {
            data?.plant_id?.let {plant_id ->
                delegate.onClicked(plant_id)
            }
        }
    }
    override fun bindData(data: PlantVO) {

        itemView.fav_toggle.setOnClickListener {
                delegate.addFavourite(data.plant_id, itemView.fav_toggle.isChecked)
        }

        Glide.with(itemView.plant_iv).load(data.plant_photo).into(itemView.plant_iv)
        itemView.plant_name.text = "by " + data.plant_name
        Glide.with(itemView.profile_iv).load(data.uploadUserVO.user_photo).into(itemView.profile_iv)
        itemView.user_name.text = "by " + data.uploadUserVO.name
    }
}