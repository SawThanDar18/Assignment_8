package com.example.assignment_8.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemView: View): RecyclerView.ViewHolder(itemView) {

    var data: T? = null
    set(value) {
        field = value

        value.let {
            bindData(it!!)
        }
    }

    abstract fun bindData(data: T)

}