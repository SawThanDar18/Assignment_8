package com.example.assignment_8.mvp.presenters

import com.example.assignment_8.activities.BaseActivity
import com.example.assignment_8.data.models.PlantModelImpl
import com.example.assignment_8.delegates.ItemClicked
import com.example.assignment_8.mvp.views.FavouritePlantListView

class FavouritePlantListPresenter: BasePresenter<FavouritePlantListView>(), ItemClicked {

    override fun onClicked(plant_id: String) {
        mView.navigateToPlantDetail(plant_id)
    }

    override fun addFavourite(id: String, toggleStatus: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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