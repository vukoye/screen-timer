package com.vukoye.screentimer.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.vukoye.screentimer.R


class ScreenEventViewHolder(v : View) : RecyclerView.ViewHolder(v) {
    val typeView = v.findViewById<TextView>(R.id.screen_event_item_type)
    val dateView = v.findViewById<TextView>(R.id.screen_event_item_date)
}
