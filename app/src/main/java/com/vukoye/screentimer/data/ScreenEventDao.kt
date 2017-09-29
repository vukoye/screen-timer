package com.vukoye.screentimer.data

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListProvider
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface ScreenEventDao {

    @Insert
    fun insert(event: ScreenEvent)

    @Delete
    fun delete(event: ScreenEvent)

    @Query("SELECT * FROM ScreenEvent ORDER BY date DESC")
    fun allScreenEventsPaged(): LivePagedListProvider<Int, ScreenEvent>

    @Query("SELECT * FROM ScreenEvent ORDER BY date DESC")
    fun allScreenEvents(): LiveData<List<ScreenEvent>>

    @Query("SELECT * FROM ScreenEvent WHERE type = :type ORDER BY date DESC LIMIT 1")
    fun getLastScreenEventOfType(type : Int): ScreenEvent?
}
