package com.vukoye.screentimer.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface ScreenIntervalDao {

    @Insert
    fun insert(interval : ScreenInterval)

    @Delete
    fun delete(interval: ScreenInterval)

    @Query("SELECT * from ScreenInterval ORDER BY start_date ASC")
    fun getAllScreenIntervals() : LiveData<List<ScreenInterval>>

    @Update
    fun update(interval: ScreenInterval)
}
