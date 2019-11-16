package com.example.assignment_8.mvp.presenters

import com.example.assignment_8.activities.BaseActivity
import com.example.assignment_8.data.models.PlantModelImpl
import com.example.assignment_8.delegates.ItemClicked
import com.example.assignment_8.mvp.views.FavouritePlantListView
import android.widget.ImageView

class FavouritePlantListPresenter: BasePresenter<FavouritePlantListView>(), ItemClicked {

    override fun onClicked(plant_id: String, plantImageView: ImageView) {
        mView.navigateToPlantDetail(plant_id, plantImageView)
    }

    override fun addFavourite(id: String, toggleStatus: Boolean) {

    }

   fun onUIReady(activity: BaseActivity) {
        val model = PlantModelImpl
        model.getFavouritePlant(onSuccess = {
            mView.displayFavouritePlantList(it)
        }, onFailure = {
            mView.displayErrorMessage(it)
        })
    }
}