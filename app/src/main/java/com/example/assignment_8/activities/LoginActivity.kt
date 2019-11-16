package com.example.assignment_8.activities

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.transition.Fade
import android.transition.Slide
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.addListener
import com.example.assignment_8.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_login)

        userName_et.text = "john@gmail.com"

        login_btn.setOnClickListener {
            startActivity(Intent(this, PlantListActivity::class.java))
        }

        setUpFadeTransition()
    }

    private fun setUpFadeTransition() {
        loginTxt_layout.visibility = View.VISIBLE

        val animator = ObjectAnimator.ofFloat(loginTxt_layout, View.ALPHA, 0f, 1f)
        animator.addListener(object: AnimatorListenerAdapter(){
            override fun onAnimationEnd(animation: Animator?) {
                setUpSlideTransition()
            }
        })

        animator.interpolator = AccelerateDecelerateInterpolator()
        animator.duration = 2000
        animator.start()
    }

    private fun setUpSlideTransition(){

        user_layout.visibility = View.VISIBLE

        val animator = ObjectAnimator.ofFloat(user_layout, View.TRANSLATION_X, 600f, user_layout.width.toFloat())
        animator.addListener(object: AnimatorListenerAdapter(){
            override fun onAnimationEnd(animation: Animator?) {
                setUpBtnTransition()
            }
        })

        animator.interpolator = OvershootInterpolator()
        animator.duration = 2000
        animator.start()
    }

    private fun setUpBtnTransition(){

        login_btn.visibility = View.VISIBLE
        val animator = ObjectAnimator.ofFloat(login_btn, View.TRANSLATION_X, -600f, login_btn.width.toFloat())
        animator.interpolator = OvershootInterpolator()
        animator.duration = 2000
        animator.start()
    }
}