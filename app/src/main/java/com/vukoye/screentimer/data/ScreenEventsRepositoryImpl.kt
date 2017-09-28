package com.vukoye.screentimer.data

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListProvider
import io.reactivex.Completable
import org.threeten.bp.LocalDateTime
import timber.log.Timber


class ScreenEventsRepositoryImpl(private val screenEventDb : ScreenEventDb?) : ScreenEventsRepository {

    override fun addScreenEvent(screenEvent: ScreenEvent): Completable {
        if (screenEventDb != null) {
            return Completable.fromAction {
                val startType = if (screenEvent.type == ScreenEvent.SCREEN_OFF) ScreenEvent.SCREEN_ON else ScreenEvent.SCREEN_OFF
                val startScreenEvent = screenEventDb.screenEventDao().getLastScreenEventOfType(startType)
                val startTime = if (startScreenEvent != null) startScreenEvent.date else LocalDateTime.MIN
                val screenInterval = ScreenInterval(startDate = startTime, endDate = LocalDateTime.now(), type = screenEvent.type, comment = "")
                screenEventDb.screenEventDao().insert(screenEvent)
                screenEventDb.screenIntervalDao().insert(screenInterval)
            }
        } else {
            return Completable.fromAction { Timber.d("Problem with adding screen event")}
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

    override fun getScreenIntervals(): LiveData<List<ScreenInterval>> {
        return screenEventDb!!.screenIntervalDao().getAllScreenIntervals();
    }

    override fun updateScreenInterval(screenInterval: ScreenInterval) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
