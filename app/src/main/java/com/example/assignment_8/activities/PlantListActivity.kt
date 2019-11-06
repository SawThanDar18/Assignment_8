package com.example.assignment_8.activities

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.widget.TextView
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

    override fun navigateToPlantDetail(plant_id: String) {
        startActivity(DetailActivity.newIntent(applicationContext, plant_id))
    }

    private lateinit var plantListPresenter: PlantListPresenter
    private lateinit var plantItemAdapter: PlantItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_plant_list)

        plantListPresenter = PlantListPresenter()
        plantListPresenter.initPresenter(this)

        plantItemAdapter = PlantItemAdapter(plantListPresenter)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this@PlantListActivity)
        recyclerView.adapter = plantItemAdapter

        profile_iv.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

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

        navigation.setOnClickListener {
            startActivity(Intent(this, FavouritePlantActivity::class.java))
        }

        plantListPresenter.onUIReady(this)
    }

    fun searchByKeyword(keyword: String){
        plantItemAdapter.setNewData(plantModel.getPlantsByName(keyword) as MutableList<PlantVO>)
        recyclerView.adapter = plantItemAdapter
    }
}