package com.vukoye.screentimer.di

import android.arch.persistence.room.Room
import android.content.Context
import com.vukoye.screentimer.ScreenTimerApplication
import com.vukoye.screentimer.data.ScreenEventDb
import com.vukoye.screentimer.data.ScreenEventsRepository
import com.vukoye.screentimer.data.ScreenEventsRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataModule(val screenTimerApplication: ScreenTimerApplication) {

    @Provides
    fun applicationContext() : Context{
        return screenTimerApplication;
    }

    @Provides
    @Singleton
    fun providesScreenEventsRepo(screenEventDb: ScreenEventDb) : ScreenEventsRepository{
        return ScreenEventsRepositoryImpl(screenEventDb)
    }


    @Provides
    @Singleton
    fun providesScreenEventDatabase(context: Context): ScreenEventDb {
        return Room.databaseBuilder(context.applicationContext, ScreenEventDb::class.java, "screen_events_db").build()
    }


}
