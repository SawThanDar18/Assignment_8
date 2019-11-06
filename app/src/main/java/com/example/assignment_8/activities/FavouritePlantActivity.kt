package com.example.assignment_8.activities

import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.GridLayoutManager
import com.example.assignment_8.R
import com.example.assignment_8.adapters.FavouriteItemAdapter
import com.example.assignment_8.data.vos.PlantVO
import com.example.assignment_8.mvp.presenters.FavouritePlantListPresenter
import com.example.assignment_8.mvp.views.FavouritePlantListView
import kotlinx.android.synthetic.main.activity_favourite.*

class FavouritePlantActivity : BaseActivity(), FavouritePlantListView {

    override fun navigateToPlantDetail(plant_id: String) {
        startActivity(DetailActivity.newIntent(applicationContext, plant_id))
    }

    override fun displayFavouritePlantList(plantVO: List<PlantVO>) {
        favouriteItemAdapter.setNewData(plantVO as MutableList<PlantVO>)
    }

    override fun displayErrorMessage(message: String) {
        showSnackBar(message)
    }

    private lateinit var favouritePlantListPresenter: FavouritePlantListPresenter
    private lateinit var favouriteItemAdapter: FavouriteItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_favourite)

        favouritePlantListPresenter = FavouritePlantListPresenter()
        favouritePlantListPresenter.initPresenter(this)

        favouriteItemAdapter = FavouriteItemAdapter(favouritePlantListPresenter)
        with(favourite_rV){
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
            adapter = favouriteItemAdapter
        }

        favouritePlantListPresenter.onUIReady(this)
    }
}