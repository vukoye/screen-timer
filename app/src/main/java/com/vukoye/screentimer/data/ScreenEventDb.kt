package com.vukoye.screentimer.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters

@Database(entities = arrayOf(ScreenEvent::class, ScreenInterval::class), version = 1)
@TypeConverters(LocalDateConverter::class)
abstract class ScreenEventDb : RoomDatabase() {
    abstract fun screenEventDao() : ScreenEventDao
    abstract fun screenIntervalDao() : ScreenIntervalDao

}
