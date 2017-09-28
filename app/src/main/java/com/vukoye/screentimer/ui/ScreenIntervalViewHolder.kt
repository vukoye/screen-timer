package com.vukoye.screentimer.ui

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.View
import com.vukoye.screentimer.R

class ScreenIntervalViewHolder(v : View) : RecyclerView.ViewHolder(v) {
    val container = v.findViewById<ConstraintLayout>(R.id.screen_interval_item_holder)
}
