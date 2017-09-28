package com.vukoye.screentimer.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vukoye.screentimer.R
import com.vukoye.screentimer.data.ScreenInterval


class ScreeIntervalAdapter(val context : Context, val viewClickListener : View.OnClickListener)
    : RecyclerView.Adapter<ScreenIntervalViewHolder>() {

    var screenIntervals : List<ScreenInterval> =  ArrayList<ScreenInterval>()

    override fun getItemCount(): Int {
        return screenIntervals.size
    }

    override fun onBindViewHolder(viewHolder: ScreenIntervalViewHolder, position: Int) {
        val screenInterval = screenIntervals.get(position)
        if (screenInterval.type == ScreenInterval.TYPE_SCREEN_OFF || screenInterval.type == ScreenInterval.TYPE_SCREEN_OFF_SLEEPING) {
            viewHolder.container.setBackgroundColor(context.resources.getColor(R.color.colorScreenOff))
        } else {
            viewHolder.container.setBackgroundColor(context.resources.getColor(R.color.colorScreenOn))
        }
        viewHolder.container.setOnClickListener(viewClickListener)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScreenIntervalViewHolder {
        return ScreenIntervalViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.screen_interval_item, parent, false))
    }

    fun setItems(intervals: List<ScreenInterval>?) {
        if (intervals != null) {
            this.screenIntervals = intervals
        } else {
            this.screenIntervals = ArrayList<ScreenInterval>()
        }
        notifyDataSetChanged()
    }

}
