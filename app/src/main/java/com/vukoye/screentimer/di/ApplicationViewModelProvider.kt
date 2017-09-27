package com.vukoye.screentimer.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.vukoye.screentimer.ScreenTimerApplication


class ApplicationViewModelProvider(val screenTimerApplication: ScreenTimerApplication) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass : Class<T>): T {
        val t = super.create(modelClass)
        if (t is ApplicationComponent.Injectable) {
            (t as ApplicationComponent.Injectable).inject(screenTimerApplication.applicationComponent)
        }
        return t
    }

}
