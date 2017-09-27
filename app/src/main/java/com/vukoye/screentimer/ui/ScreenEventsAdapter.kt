package com.vukoye.screentimer.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vukoye.screentimer.R
import com.vukoye.screentimer.data.ScreenEvent
import org.threeten.bp.format.DateTimeFormatter


class ScreenEventsAdapter(val context : Context, val viewClickListener : View.OnClickListener)
    : RecyclerView.Adapter<ScreenEventViewHolder>() {

    var screenEvents : List<ScreenEvent> =  ArrayList<ScreenEvent>()

    override fun getItemCount(): Int {
        return screenEvents.size
    }

    override fun onBindViewHolder(viewHolder: ScreenEventViewHolder, position: Int) {
        val screenEvent = screenEvents.get(position)
        viewHolder.typeView.text = screenEvent.type.toString()
        viewHolder.dateView.text = screenEvent.date.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        viewHolder.dateView.setOnClickListener(viewClickListener)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScreenEventViewHolder {
        return ScreenEventViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.screen_event_item, parent, false))
    }

    fun setItems(events: List<ScreenEvent>?) {
        if (events != null) {
            this.screenEvents = events
        } else {
            this.screenEvents = ArrayList<ScreenEvent>()
        }
        notifyDataSetChanged()
    }

}
