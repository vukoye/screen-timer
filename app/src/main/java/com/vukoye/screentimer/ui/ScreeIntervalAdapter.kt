package com.vukoye.screentimer.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vukoye.screentimer.R
import com.vukoye.screentimer.data.ScreenInterval
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.temporal.ChronoUnit
import timber.log.Timber


class ScreeIntervalAdapter(val context : Context, val viewClickListener : View.OnClickListener)
    : RecyclerView.Adapter<ScreenIntervalViewHolder>() {

    var screenIntervals : List<ScreenInterval> =  ArrayList<ScreenInterval>()
    val minHeight = context.resources.getDimensionPixelSize(R.dimen.iterval_item_min_size)
    val maxHeight = context.resources.getDimensionPixelSize(R.dimen.iterval_item_max_size)
    val heightPerHour = context.resources.getDimensionPixelSize(R.dimen.iterval_item_per_hour_size)


    override fun getItemCount(): Int {
        return screenIntervals.size
    }

    override fun onBindViewHolder(viewHolder: ScreenIntervalViewHolder, position: Int) {
        val screenInterval = screenIntervals.get(position)
        if (screenInterval.type == ScreenInterval.TYPE_SCREEN_OFF || screenInterval.type == ScreenInterval.TYPE_SCREEN_OFF_SLEEPING) {
            viewHolder.container.setBackgroundResource(R.drawable.gradient_off)
            viewHolder.startTime.setTextColor(context.resources.getColor(R.color.abc_primary_text_material_dark))
        } else {
            viewHolder.container.setBackgroundResource(R.drawable.gradient_on)
            viewHolder.startTime.setTextColor(context.resources.getColor(R.color.abc_primary_text_material_light))
        }
        val hours = ChronoUnit.HOURS.between(screenInterval.endDate, screenInterval.startDate).toInt()
        Timber.d("Hours: " +  hours)
        var height =  hours * heightPerHour
        height = if (height > maxHeight) maxHeight else if (height < minHeight) minHeight else height
        val params = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, height)
        viewHolder.container.layoutParams = params
        viewHolder.startTime.text = screenInterval.startDate.format(DateTimeFormatter.ISO_LOCAL_TIME)
        viewHolder.endTime.text = screenInterval.endDate.format(DateTimeFormatter.ISO_LOCAL_TIME)
        viewHolder.container.setOnClickListener(viewClickListener)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScreenIntervalViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.screen_interval_item, parent, false)
        return ScreenIntervalViewHolder(view)

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
