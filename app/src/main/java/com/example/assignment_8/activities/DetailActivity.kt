package com.example.assignment_8.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import com.bumptech.glide.Glide
import com.example.assignment_8.R
import com.example.assignment_8.adapters.DetailImageAdapter
import com.example.assignment_8.data.vos.PlantVO
import com.example.assignment_8.mvp.presenters.PlantDetailPresenter
import com.example.assignment_8.mvp.views.PlantDetailView
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity: BaseActivity(), PlantDetailView {

    override fun displayPlantData(data: PlantVO) {
        bindData(data)
    }

    private lateinit var plantDetailPresenter: PlantDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_detail)

        plant_iv_viewPager.adapter = DetailImageAdapter()

        plantDetailPresenter = PlantDetailPresenter()
        plantDetailPresenter.initPresenter(this)

        val plant_id = intent.getStringExtra(EXTRA_EVENT_ID)
        plantDetailPresenter.onUIReady(plant_id)

        back_iv.setOnClickListener {
            finish()
        }

        plantDetailPresenter.onCreate()
    }

    override fun onStart() {
        super.onStart()
        plantDetailPresenter.onStart()
    }

    override fun onPause() {
        super.onPause()
        plantDetailPresenter.onPause()
    }

    override fun onResume() {
        super.onResume()
        plantDetailPresenter.onResume()
    }

    override fun onStop() {
        super.onStop()
        plantDetailPresenter.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        plantDetailPresenter.onDestroy()
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

    fun bindData(data: PlantVO){
        detail_plant_name.text = data.plant_name
        Glide.with(detail_user_iv).load(data.uploadUserVO.user_photo).into(detail_user_iv)
        detail_user_name.text = data.uploadUserVO.name
        detail_desc.text = data.description
        temperature_tv.text = data.tipsVO.temperature
        light_tv.text = data.tipsVO.light
        placement_tv.text = data.tipsVO.placement
    }
}