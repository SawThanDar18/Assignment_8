package com.example.assignment_8.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.assignment_8.R

class DetailImageAdapter: PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater = LayoutInflater.from(container.context)
        val view = layoutInflater.inflate(R.layout.item_detail_image, container, false)
        container.addView(view)
        return view
    }

    override fun getCount(): Int {
        return 4
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}