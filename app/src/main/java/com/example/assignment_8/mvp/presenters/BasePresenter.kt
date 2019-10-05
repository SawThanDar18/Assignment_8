package com.example.assignment_8.mvp.presenters

import androidx.lifecycle.ViewModel
import com.example.assignment_8.mvp.views.BaseView

abstract class BasePresenter<T: BaseView>: ViewModel() {

    protected lateinit var mView: T

    open fun initPresenter(view: T){
        this.mView = view
    }

    open fun onCreate(){}

    open fun onStart(){}

    open fun onPause(){}

    open fun onResume(){}

    open fun onStop(){}

    open fun onDestroy(){}
}