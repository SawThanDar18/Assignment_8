package com.example.assignment_8.mvp.presenters

import android.widget.ImageView
import androidx.lifecycle.Observer
import com.example.assignment_8.activities.BaseActivity
import com.example.assignment_8.data.models.PlantModelImpl
import com.example.assignment_8.data.vos.FavouritePlantVO
import com.example.assignment_8.delegates.ItemClicked
import com.example.assignment_8.mvp.views.PlantListView
import com.example.assignment_8.utils.EM_NULL_RESPONSE

class PlantListPresenter: BasePresenter<PlantListView>(), ItemClicked {

    override fun addFavourite(id: String, toggleStatus: Boolean) {
        var favouritePlantVO = FavouritePlantVO(favourite_plant_id = id, id = 0)
        if (toggleStatus){
            PlantModelImpl.addFavouritePlant(favouritePlantVO)
        }else{
            favouritePlantVO = PlantModelImpl.getFavouritePlantById(id)
            PlantModelImpl.deleteFavouritePlant(favouritePlantVO)
        }
    }

    override fun onClicked(plant_id: String, plantImageView: ImageView) {
        mView.navigateToPlantDetail(plant_id, plantImageView)
    }

    fun onUIReady(activity: BaseActivity) {
        val model = PlantModelImpl
        model.getPlants{ mView.displayErrorMessage(it)}
            .observe(activity, Observer {
                mView.displayPlantList(it)
            })

    }
}