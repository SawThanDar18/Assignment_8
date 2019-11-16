package com.example.assignment_8.activities

import android.animation.ObjectAnimator
import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.OvershootInterpolator
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.GridLayoutManager
import com.example.assignment_8.R
import com.example.assignment_8.adapters.FavouriteItemAdapter
import com.example.assignment_8.data.vos.PlantVO
import com.example.assignment_8.mvp.presenters.FavouritePlantListPresenter
import com.example.assignment_8.mvp.views.FavouritePlantListView
import kotlinx.android.synthetic.main.activity_favourite.*

class FavouritePlantActivity : BaseActivity(), FavouritePlantListView {

    override fun navigateToPlantDetail(plant_id: String, plantImageView: ImageView) {
        val pair = Pair.create(plantImageView as View, "plantTransition")
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,pair)
        startActivity(DetailActivity.newIntent(this,plant_id),options.toBundle())
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

       // setUpPopupTransition()

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

        setUpPopupTransition()
    }

    private fun setUpPopupTransition(){

        favourite_layout.visibility = View.VISIBLE
        val animator = ObjectAnimator.ofFloat(favourite_layout, View.TRANSLATION_Y, favourite_layout.height.toFloat(), 0f)
        animator.interpolator = OvershootInterpolator()
        animator.duration = 2000
        animator.start()

        /*with(window){
            requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
            val slideTransition = Slide()
            slideTransition.slideEdge = Gravity.BOTTOM
            slideTransition.duration = 1000
            slideTransition.interpolator = OvershootInterpolator()
            enterTransition = slideTransition
            exitTransition = slideTransition
        }*/
    }
}