package com.example.assignment_8.viewHolders

import android.view.View
import com.bumptech.glide.Glide
import com.example.assignment_8.R
import com.example.assignment_8.data.vos.PlantVO
import com.example.assignment_8.delegates.ItemClicked
import com.example.assignment_8.delegates.RecentItemClicked
import kotlinx.android.synthetic.main.home_item_view.view.*

class PlantItemViewHolder(itemView: View, private val delegate: ItemClicked): BaseViewHolder<PlantVO>(itemView) {

    init {
        itemView.setOnClickListener {
            data?.plant_id?.let {plant_id ->
                delegate.onClicked(plant_id)
            }
        }

        itemView.fav_iv.setOnClickListener {
            itemView.fav_iv.setBackgroundResource(R.color.colorAccent)
            data?.plant_photo?.let {plant_photo ->
                delegate.addFavourite(plant_photo)
            }
        }
    }
    override fun bindData(data: PlantVO) {
        Glide.with(itemView.plant_iv).load(data.plant_photo).into(itemView.plant_iv)
        itemView.plant_name.text = data.plant_name
        Glide.with(itemView.profile_iv).load(data.uploadUserVO.user_photo).into(itemView.profile_iv)
        itemView.user_name.text = "by " + data.uploadUserVO.name
    }
}