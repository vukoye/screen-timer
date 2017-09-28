package com.vukoye.screentimer.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import org.threeten.bp.LocalDateTime



@Entity
data class ScreenEvent(@ColumnInfo(name = "type")val type: Int, @ColumnInfo(name = "name") val name: String,
                       @ColumnInfo(name = "date") var date: LocalDateTime = LocalDateTime.MIN) {


    companion object {
        val SCREEN_ON = 1
        val SCREEN_OFF = 0
    }
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
