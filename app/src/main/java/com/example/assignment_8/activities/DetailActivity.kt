package com.example.assignment_8.activities

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.transition.TransitionListenerAdapter
import android.view.View
import android.view.WindowManager
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.lifecycle.LiveData
import com.bumptech.glide.Glide
import com.example.assignment_8.R
import com.example.assignment_8.adapters.DetailImageAdapter
import com.example.assignment_8.data.models.PlantModelImpl
import com.example.assignment_8.data.vos.FavouritePlantVO
import com.example.assignment_8.data.vos.PlantVO
import com.example.assignment_8.mvp.presenters.PlantDetailPresenter
import com.example.assignment_8.mvp.views.PlantDetailView
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_plant_list.*
import kotlinx.android.synthetic.main.item_detail_image.*

class DetailActivity: BaseActivity(), PlantDetailView {

    override fun displayPlantData(data: PlantVO) {
        bindData(data)
    }

    var isFavourite: Boolean = false

    private lateinit var plantDetailPresenter: PlantDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //plant_iv_viewPager.adapter = DetailImageAdapter()

        plantDetailPresenter = PlantDetailPresenter()
        plantDetailPresenter.initPresenter(this)

        val plant_id = intent.getStringExtra(EXTRA_EVENT_ID)
        plantDetailPresenter.onUIReady(this, plant_id)

        setUpListener()

        setUpSlideTransition()
    }

    private fun setUpSlideTransition(){
        tips.visibility = View.VISIBLE
        val animator = ObjectAnimator.ofFloat(tips, View.TRANSLATION_X, 800f, tips.width.toFloat())
        animator.addListener(object: AnimatorListenerAdapter(){
            override fun onAnimationEnd(animation: Animator?) {
                setUpScaleAnimation()
            }
        })
        animator.interpolator = AccelerateDecelerateInterpolator()
        animator.duration = 2000
        animator.start()
    }

    private fun setUpScaleAnimation(){
        lottie_Fav.visibility = View.VISIBLE
        val alphaAnimator = ObjectAnimator.ofFloat(
            lottie_Fav,
            View.ALPHA,
            0f,
            1f)

        val xAnimator = ObjectAnimator.ofFloat(
            lottie_Fav,
            View.SCALE_X,
            0f,
            1f
        )
        xAnimator.duration = 3000

        val yAnimator = ObjectAnimator.ofFloat(
            lottie_Fav,
            View.SCALE_Y,
            0f,
            1f
        )

        AnimatorSet().apply {
            play(alphaAnimator).with(xAnimator).with(yAnimator)
            start()
        }
    }

    private fun setUpListener(){
        back_iv.setOnClickListener {
            finish()
        }

        lottie_Fav.setOnClickListener {

            if (!isFavourite){
                val animator = AnimationUtils.loadAnimation(applicationContext, R.anim.rotate)
                lottie_Fav.startAnimation(animator)
                lottie_Fav.speed = 1f
                lottie_Fav.playAnimation()
                isFavourite = true
            }else {
                lottie_Fav.speed = -4.0f
                lottie_Fav.playAnimation()
                isFavourite = false
            }
        }
    }

    companion object{
        const val EXTRA_EVENT_ID = "plant_id"

        fun newIntent(context: Context, plant_id: String): Intent {

            //scope function
            return Intent(context, DetailActivity::class.java).apply {
                putExtra(EXTRA_EVENT_ID, plant_id)
            }

        }
    }

    private fun bindData(data: PlantVO){
        detail_plant_name.text = data.plant_name
        Glide.with(detail_user_iv).load(data.uploadUserVO.user_photo).into(detail_user_iv)
        detail_user_name.text = data.uploadUserVO.name
        detail_desc.text = data.description
        temperature_tv.text = data.tipsVO.temperature
        light_tv.text = data.tipsVO.light
        placement_tv.text = data.tipsVO.placement
        Glide.with(plant_iv_detail).load(data.plant_photo).into(plant_iv_detail)
    }
}