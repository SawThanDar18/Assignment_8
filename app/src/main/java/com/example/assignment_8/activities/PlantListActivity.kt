package com.example.assignment_8.activities

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.transition.Fade
import android.transition.Slide
import android.transition.Transition
import android.transition.TransitionListenerAdapter
import android.view.*
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.inputmethod.EditorInfo
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment_8.R
import com.example.assignment_8.adapters.PlantItemAdapter
import com.example.assignment_8.data.vos.PlantVO
import com.example.assignment_8.mvp.presenters.PlantListPresenter
import com.example.assignment_8.mvp.views.PlantListView
import kotlinx.android.synthetic.main.activity_plant_list.*

class PlantListActivity: BaseActivity(), PlantListView {

    override fun displayPlantList(plantList: List<PlantVO>) {
            plantItemAdapter.setNewData(plantList as MutableList<PlantVO>)
    }

    override fun displayErrorMessage(message: String) {
        showSnackBar(message)
    }

    override fun navigateToPlantDetail(plant_id: String, plantImageView: ImageView) {

        val pair = Pair.create(plantImageView as View, "plantTransition")
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,pair)
        startActivity(DetailActivity.newIntent(this,plant_id),options.toBundle())
    }

    private lateinit var plantListPresenter: PlantListPresenter
    private lateinit var plantItemAdapter: PlantItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setUpFadeTransition()

        setContentView(R.layout.activity_plant_list)

        setUpPresenter()
        setUpRecycler()
        setUpListener()
        setUpEditableText()

        plantListPresenter.onUIReady(this)

        setUpSlideTransition()
    }

    private fun setUpFadeTransition(){
        with(window){
            requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
            val fadeTransition = Fade()
            fadeTransition.interpolator = AccelerateDecelerateInterpolator()
            fadeTransition.duration = 2000
            enterTransition = fadeTransition
            exitTransition = fadeTransition

            fadeTransition.addListener(object: TransitionListenerAdapter(){
                override fun onTransitionEnd(transition: Transition?) {
                    setUpSlideTransition()
                }
            })
        }
    }

    private fun setUpSlideTransition(){
        recyclerView.visibility = View.VISIBLE
        val animator = ObjectAnimator.ofFloat(recyclerView, View.TRANSLATION_X, 800f, recyclerView.width.toFloat())
        animator.interpolator = AccelerateDecelerateInterpolator()
        animator.duration = 3000
        animator.start()
    }

    private fun setUpPresenter(){
        plantListPresenter = PlantListPresenter()
        plantListPresenter.initPresenter(this)
    }

    private fun setUpRecycler(){
        with(recyclerView) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@PlantListActivity)
            plantItemAdapter = PlantItemAdapter(plantListPresenter)
            adapter = plantItemAdapter
        }
    }

    private fun setUpListener(){
        profile_iv.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        navigation.setOnClickListener {
            startActivity(Intent(this, FavouritePlantActivity::class.java))
        }

    }

    private fun setUpEditableText(){
        search_et.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val search_keyword = search_et.text.toString()
                return@OnEditorActionListener true
            }
            false
        })

        search_et.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL) {
                plantListPresenter.onUIReady(this)
            }
            false
        }

        search_et.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                searchByKeyword(s.toString())
            }
        })
    }

    private fun searchByKeyword(keyword: String){
        plantItemAdapter.setNewData(plantModel.getPlantsByName(keyword) as MutableList<PlantVO>)
        recyclerView.adapter = plantItemAdapter
    }
}