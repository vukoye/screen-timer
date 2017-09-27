package com.vukoye.screentimer

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import com.vukoye.screentimer.di.ApplicationComponent
import com.vukoye.screentimer.di.DaggerApplicationComponent
import com.vukoye.screentimer.di.DataModule
import timber.log.Timber


class ScreenTimerApplication : Application() {

    val applicationComponent = createApplicationComponent();

    private fun createApplicationComponent(): ApplicationComponent {
        return DaggerApplicationComponent.builder().dataModule(DataModule(this)).build()
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }


}
