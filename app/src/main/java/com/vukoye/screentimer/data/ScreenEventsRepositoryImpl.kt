package com.vukoye.screentimer.data

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListProvider
import io.reactivex.Completable
import timber.log.Timber


class ScreenEventsRepositoryImpl(private val screenEventDb : ScreenEventDb?) : ScreenEventsRepository {

    override fun addScreenEvent(screenEvent: ScreenEvent): Completable {
        if (screenEventDb != null) {
            return Completable.fromAction { screenEventDb.screenEventDao().insert(screenEvent) }
        } else {
            return Completable.fromAction { Timber.d("Problem")}
        }
    }

    override fun getScreenEventsPaged(): LivePagedListProvider<Int, ScreenEvent> {
        return screenEventDb!!.screenEventDao().allScreenEventsPaged()
    }

    override fun deleteScreenEvent(screenEvent: ScreenEvent): Completable {
        return Completable.fromAction{ screenEventDb!!.screenEventDao().delete(screenEvent) }
    }

    override fun getScreenEvents(): LiveData<List<ScreenEvent>> {
        return screenEventDb!!.screenEventDao().allScreenEvents()
    }

}
