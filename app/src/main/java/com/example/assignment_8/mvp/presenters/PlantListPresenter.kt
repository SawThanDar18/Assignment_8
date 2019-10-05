package com.example.assignment_8.mvp.presenters

import com.example.assignment_8.data.models.PlantModelImpl
import com.example.assignment_8.delegates.ItemClicked
import com.example.assignment_8.delegates.RecentItemClicked
import com.example.assignment_8.mvp.views.PlantListView
import com.example.assignment_8.utils.EM_NULL_RESPONSE

class PlantListPresenter: BasePresenter<PlantListView>(), ItemClicked {
    override fun addFavourite(image: String) {

    }

    override fun onClicked(plant_id: String) {
        mView.navigateToPlantDetail(plant_id)
    }

    override fun onCreate() {

        val model = PlantModelImpl
        model.getPlants(onSuccess = {
            mView.displayPlantList(it)
        },
            onFailure = {
                mView.displayErrorMessage(EM_NULL_RESPONSE)
            })

    }
}