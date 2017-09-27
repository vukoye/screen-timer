package com.vukoye.screentimer.screenactions

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.vukoye.screentimer.ScreenTimerApplication
import com.vukoye.screentimer.data.ScreenEvent
import com.vukoye.screentimer.data.ScreenEventsRepository
import io.reactivex.CompletableObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import org.threeten.bp.LocalDateTime
import timber.log.Timber
import javax.inject.Inject

class ScreenReceiver : BroadcastReceiver() {

    @Inject
    lateinit var screenEventsRepo: ScreenEventsRepository

    override fun onReceive(context: Context, intent: Intent) {
        (context.applicationContext as ScreenTimerApplication).applicationComponent.inject(this)
        doAsync {
            if (intent.action == Intent.ACTION_SCREEN_OFF) {
                screenEventsRepo.addScreenEvent(ScreenEvent(0, "ScreenOFF", LocalDateTime.now())).observeOn(AndroidSchedulers.mainThread())
                        .subscribe(object : CompletableObserver {
                            override fun onComplete() {
                                Timber.d("OnCompleteACTION_SCREEN_ON ")
                            }

                            override fun onSubscribe(d: Disposable) {

                            }

                            override fun onError(e: Throwable) {
                                Timber.d("OnError ACTION_SCREEN_ON " + e.stackTrace)
                            }

                        })
                Timber.d("Screen OFF")
            } else if (intent.action == Intent.ACTION_SCREEN_ON) {
                screenEventsRepo.addScreenEvent(ScreenEvent(1, "ScreenON", LocalDateTime.now())).observeOn(AndroidSchedulers.mainThread())
                        .subscribe(object : CompletableObserver {
                            override fun onComplete() {
                                Timber.d("OnComplete ACTION_SCREEN_ON")
                            }

                            override fun onSubscribe(d: Disposable) {

                            }

                            override fun onError(e: Throwable) {
                                Timber.d("OnError ACTION_SCREEN_ON" + e.stackTrace)
                            }

                        })
                Timber.d("Screen ON")
            }
        }
    }

    private inline fun doAsync(crossinline f: () -> Unit) {
        Thread({ f() }).start()
    }
}
