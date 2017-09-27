package com.vukoye.screentimer.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.vukoye.screentimer.data.ScreenEvent
import com.vukoye.screentimer.data.ScreenEventsRepository
import com.vukoye.screentimer.di.ApplicationComponent
import io.reactivex.CompletableObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject


class ScreenEventListViewModel : ViewModel(), ApplicationComponent.Injectable {

    @Inject
    lateinit var screenEventsRepo : ScreenEventsRepository

//    var screenEvents = screenEventsRepo.getScreenEventsPaged().create(0,
//            PagedList.Config.Builder().setPageSize(30).setEnablePlaceholders(true).build())

    var screenEvents : LiveData<List<ScreenEvent>> =  MutableLiveData<List<ScreenEvent>>()

    override fun inject(applicationComponent: ApplicationComponent) {
        applicationComponent.inject(this)
//        screenEvents = screenEventsRepo.getScreenEventsPaged().create(0,
//                PagedList.Config.Builder().setPageSize(30).setEnablePlaceholders(true).build())
        screenEvents = screenEventsRepo.getScreenEvents()
    }

    fun deleteScreenEvent(screenEvent: ScreenEvent) {
        screenEventsRepo.deleteScreenEvent(screenEvent).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : CompletableObserver {
                    override fun onComplete() {
                        Timber.d("onSubscribe - deleted event")
                    }

                    override fun onSubscribe(d: Disposable) {
                        Timber.d("onSubscribe - deleted event") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onError(e: Throwable) {
                        Timber.e("OnError - deleted event: ", e); //To change body of created functions use File | Settings | File Templates.
                    }

                })
    }
}
