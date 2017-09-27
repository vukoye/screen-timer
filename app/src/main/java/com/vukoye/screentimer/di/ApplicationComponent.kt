package com.vukoye.screentimer.di

import com.vukoye.screentimer.screenactions.ScreenReceiver
import com.vukoye.screentimer.ui.ScreenEventListViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(DataModule::class))
interface ApplicationComponent {
    fun inject(screenEventListViewModel : ScreenEventListViewModel)
    fun inject(screenReceiver: ScreenReceiver)

    interface Injectable {
        fun inject(applicationComponent: ApplicationComponent)
    }
}
