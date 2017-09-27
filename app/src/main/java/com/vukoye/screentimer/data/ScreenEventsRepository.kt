package com.vukoye.screentimer.data

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListProvider
import io.reactivex.Completable


interface ScreenEventsRepository {
    fun addScreenEvent(screenEvent : ScreenEvent) : Completable

    fun getScreenEventsPaged() : LivePagedListProvider<Int,ScreenEvent>

    fun deleteScreenEvent(screenEvent: ScreenEvent) : Completable

    fun getScreenEvents() : LiveData<List<ScreenEvent>>
}
